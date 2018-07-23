package claw.web.queue;

import claw.web.data.connect.Html;
import claw.web.data.entry.Href;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NewTask {
    private final static Logger logger = LoggerFactory.getLogger(Worker.class);

    private static final String TASK_QUEUE_NAME = "task_queue";


    public static void main(String[] argv) throws Exception {


        Runnable runnable = new DownloadFileRunnable();
        ScheduledExecutorService darkService = Executors.newScheduledThreadPool(5);
        darkService.scheduleWithFixedDelay(runnable, 0, 1, TimeUnit.MINUTES);

    }

    private static class DownloadFileRunnable implements Runnable {


        public DownloadFileRunnable() {

        }

        public void run() {
            String url = "http://doc.edu.vn/default.aspx";
            String cssSelector = "#documents > div.box > ul > li";

            Document document = Html.getDocument(url);
            List<String> listURL = Href.getListHrefRecursives(document, cssSelector, "a", "/tai-lieu/", "");

            logger.info("listURL.size() = " + listURL.size());


            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("172.16.9.16");
            factory.setPort(5672);
            factory.setUsername("admin");
            factory.setPassword("123456a@");
            Connection connection = null;
            try {
                connection = factory.newConnection();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

            Channel channel = null;
            try {
                channel = connection.createChannel();
                channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0, listURLSize = listURL.size(); i < listURLSize; i++) {
                String x = listURL.get(i);
                try {
//                    logger.info(" [x] Sent '" + x.toString() + "'");
                    logger.info(new Date().toString());
                    channel.basicPublish("", TASK_QUEUE_NAME,
                            null,
                            (url + "#" + x).getBytes());
                } catch (UnsupportedEncodingException e) {
                    logger.error(e.getMessage());
                } catch (IOException e){
                    logger.error(e.getMessage());
                }
            }

            try {
                channel.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (TimeoutException e) {
                e.printStackTrace();
            }


        }
    }
}