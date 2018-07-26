package claw.web.queue;
import claw.web.data.connect.Html;
import claw.web.data.entry.Href;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NewTask {
    private final static Logger logger = LoggerFactory.getLogger(NewTask.class);

    private static final String TASK_QUEUE_NAME = "url_queue";

//    private static String url = "http://doc.edu.vn/default.aspx";
//    private static String cssSelector = "#documents > div.box > ul > li";
//    private static String type = "a";
//    private static String include = "/tai-lieu/";
//    private static String exclude = "";
//    private static String deliminate = "#";

    private static String url = "http://triethoc.edu.vn";
    private static String cssSelector = "#ctl00_Default1__Body > div > div.page-wrapper.home-wrapper > div > div > ul > li > div";
    private static String type = "a";
    private static String include = ".html";
    private static String exclude = "";
    private static String deliminate = "#";

    public static void main(String[] argv) throws Exception {
        Runnable runnable = new DownloadFileRunnable();
        ScheduledExecutorService darkService = Executors.newScheduledThreadPool(5);
        darkService.scheduleWithFixedDelay(runnable, 0, 1, TimeUnit.MINUTES);
    }

    private static class DownloadFileRunnable implements Runnable {
        public DownloadFileRunnable() {
        }

        public void run() {

            Document document = Html.getDocument(url);
            List<String> listURL = Href.getListHrefRecursives(document, cssSelector, type, include, exclude);

            sendEntry(url, listURL);
        }

        private void sendEntry(String url, List<String> listURL) {
            try {
                ConnectionFactory factory = new ConnectionFactory();
                factory.setHost("172.16.9.16");
                factory.setPort(5672);
                factory.setUsername("admin");
                factory.setPassword("123456a@");
                Connection connection = factory.newConnection();

                Channel channel = connection.createChannel();
                channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);

                for (int i = 0, listURLSize = listURL.size(); i < listURLSize; i++) {
                    String x = listURL.get(i);
                    try {
                        logger.info(new Date().toString() + " [x] Sent '" + x.toString() + "' ");

                        channel.basicPublish("", TASK_QUEUE_NAME,
                                null,
                                (url + deliminate + x).getBytes());
                    } catch (UnsupportedEncodingException e) {
                        logger.error(e.getMessage());
                    }
                }

                channel.close();
                connection.close();

            } catch (IOException | TimeoutException e) {
                logger.error(e.getMessage());
            }

        }
    }
}