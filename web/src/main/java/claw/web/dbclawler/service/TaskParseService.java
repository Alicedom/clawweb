package claw.web.dbclawler.service;

import claw.web.data.connect.Html;
import claw.web.data.fulldata.DataArticle;
import claw.web.dbclawler.repository.BodyParseService;
import claw.web.dbclawler.repository.TextParseRepository;
import claw.web.dbclawler.repository.TextParseService;
import claw.web.queue.WorkerParse;
import com.rabbitmq.client.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Service
public class TaskParseService {

    public static final String folder = "D:\\home\\java\\data\\";
    private final static Logger logger = LoggerFactory.getLogger(WorkerParse.class);
    private final static String deliminate = "#";
    @Autowired
    BodyParseService bodyParseService;

    @Autowired
    TextParseService textParseService;

    @Autowired
    TextParseRepository textParseRepository;

    private void uploadSrc(int entryId, List<String> srcList) {
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
                    String sms = entryId + "#" + aSrcList;
                    logger.info(" [x] Sent '" + sms + "' ");
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

    private void uploadArticle(int entryId, DataArticle dataArticle) {
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
                String message = entryId + "#" + dataArticle.getArticle().toString();
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

    public void startWorkingParseMain() {

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

    private void doWork(String message) {
        String[] str = message.split(deliminate);
        int entryId = Integer.parseInt(str[0]);
        String url = str[1];

        Map<String, String> cssText = textParseService.findAllByEntryId(entryId);
        List<String> listBody = bodyParseService.getListBody(entryId);
        String bodyRemove = bodyParseService.getBodyRemove(entryId);

        Document document = Html.getDocument(url);
        DataArticle dataArticle = new DataArticle(url);
        Map text = dataArticle.setText(document, cssText);
        Elements body = dataArticle.setBody(document, listBody, bodyRemove, bodyRemove, folder);
        List<String> srcList = dataArticle.setSrc(body);

        uploadArticle(entryId, dataArticle);
        uploadSrc(entryId, srcList);

    }

}
