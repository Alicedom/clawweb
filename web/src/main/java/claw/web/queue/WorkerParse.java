package claw.web.queue;

import claw.web.data.connect.Html;
import claw.web.data.fulldata.DataArticle;
import com.rabbitmq.client.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.TimeoutException;

public class WorkerParse {

    private final static Logger logger = LoggerFactory.getLogger(WorkerParse.class);

    private static String removeURL;
    private static Map cssText = new TreeMap<String, String>();
    private static List<String> listBody = new LinkedList<>();
    private static String listBodyRemove;


    private static void setup() {

//        replaceURL = "http://doc.edu.vn/";
//        cssText.put("title", "#viewdoc > div.box-header.box-header-main > h1");
//        cssText.put("author", "#viewdoc > div.box > div.doc-info > span.sender");
//        cssText.put("date", "#viewdoc > div.box > div.doc-info > span.date");
//        listBody.add("#viewdoc > div.box > div.doc-intro.default");
//        listBody.add("#viewdoc > div.box > div.doc-preview");

//        replaceURL = "http://doc.edu.vn/";
//        cssText.put("title", "div.page-wrapper.page-wrapper2 > div > div.content-wrapper > h1");
//        cssText.put("date", "div.page-wrapper.page-wrapper2 > div > div.content-wrapper > div.content-date");
//        listBody.add("div.page-wrapper.page-wrapper2 > div > div.content-wrapper > div.content-des");

        removeURL = "http://doc.edu.vn/";
        cssText.put("title", "body > section.content > h1");
        cssText.put("date", "body > section.content > section.byline");
        cssText.put("author", "#lname");
        listBody.add("body > section.content");
        listBodyRemove = "body > section.content > section.meta, body > section.content > h1, body > section.content > section.byline";
    }

    public static void main(String[] argv) {

        final String TASK_QUEUE_NAME = "url_queue";

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.9.16");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("123456a@");

        try {
            final Connection connection = factory.newConnection();
            final Channel channel = connection.createChannel();

            channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);
            logger.info(" [*] Waiting for messages. To exit press CTRL+C");

            channel.basicQos(1);

            final Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");

                    logger.info(" [x] Received '" + message + "'");
                    try {

                        doWork(message);
                    } finally {
                        logger.info(" [x] Done");
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                }
            };

            boolean autoAck = false;
            channel.basicConsume(TASK_QUEUE_NAME, autoAck, consumer);


        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (TimeoutException e) {
            logger.error(e.getMessage());
        }
    }

    private static void doWork(String message) {
        String[] str = message.split("#");
        String source = str[0];
        String url = str[1];

        setup();

        Document document = Html.getDocument(url);
        DataArticle dataArticle = new DataArticle(url);
        Map text = dataArticle.setText(document, cssText);
        Elements body = dataArticle.setBody(document, listBody, listBodyRemove, removeURL, WorkerDownloadMedia.folder);
        List<String> srcList = dataArticle.setSrc(body);

//        logger.info("text: " + text.size());
//        logger.info("body : " + body.size());
//        logger.info("src : " + srcList.size());

        uploadArticle(source, dataArticle);
        uploadSrc(source, srcList);

    }

    private static void uploadSrc(String source, List<String> srcList) {
        final String SRC_QUEUE_NAME = "src_queue";

        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("172.16.9.16");
            factory.setPort(5672);
            factory.setUsername("admin");
            factory.setPassword("123456a@");
            final Connection connection = factory.newConnection();

            Channel channelSrc = connection.createChannel();
            channelSrc.queueDeclare(SRC_QUEUE_NAME, false, false, false, null);

            for (String aSrcList : srcList) {
                try {
                    String sms = source + "#" + aSrcList;
                    logger.info(" [x] Sent '" +sms + "' ");
                    channelSrc.basicPublish("", SRC_QUEUE_NAME,
                            null,
                            (sms).getBytes());
                } catch (UnsupportedEncodingException e) {
                    logger.error(e.getMessage());
                }
            }

            channelSrc.close();
            connection.close();

        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (TimeoutException e) {
            logger.error(e.getMessage());
        }
    }

    private static void uploadArticle(String source, DataArticle dataArticle) {
        final String ARTICLE_QUEUE_NAME = "article_queue";

        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("172.16.9.16");
            factory.setPort(5672);
            factory.setUsername("admin");
            factory.setPassword("123456a@");
            final Connection connection = factory.newConnection();

            Channel channelArticle = connection.createChannel();
            channelArticle.queueDeclare(ARTICLE_QUEUE_NAME, false, false, false, null);

            try {
                String message = source + "#" + dataArticle.getArticle().toString();
                logger.info(" [y] Sent '" + message + "' ");
                channelArticle.basicPublish("", ARTICLE_QUEUE_NAME,
                        null,
                        (message).getBytes());
            } catch (UnsupportedEncodingException e) {
                logger.error(e.getMessage());
            }

            channelArticle.close();
            connection.close();

        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (TimeoutException e) {
            logger.error(e.getMessage());
        }
    }

}