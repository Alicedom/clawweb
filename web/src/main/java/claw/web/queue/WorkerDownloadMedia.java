package claw.web.queue;

import com.rabbitmq.client.*;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

public class WorkerDownloadMedia {


    //    public static final String replaceURL = "http://s1.doc.edu.vn/web/viewer.html?file=http://s1.doc.edu.vn";
//    public static final String replaceURL = "http://triethoc.edu.vn/resources/uploaded/TrietHoc/Files/";
//    public static final String replaceURL = "http://triethoc.edu.vn/resources/uploaded/TrietHoc/Files/";
    public static final String replaceURL = "";
    public static final String folder = "D:\\home\\java\\data\\";
    public static final int sleepDownload = 5;
    private final static Logger logger = LoggerFactory.getLogger(WorkerDownloadMedia.class);
    private static final String TASK_QUEUE_NAME = "src_queue";

    private static ExecutorService threadPool = Executors.newFixedThreadPool(5);

    public static void main(String[] argv) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("172.16.9.16");
            factory.setPort(5672);
            factory.setUsername("admin");
            factory.setPassword("123456a@");
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
                        doWorkDownload(message);
                    } finally {
                        logger.info(" [x] Done " + message);
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

//    public static void main(String[] args) {
//        String sms = "http://doc.edu.vn/default.aspx#" +
//                "http://triethoc.edu.vn/resources/uploaded/TrietHoc/Files/Thuyết%20Duy%20tâm%20Đức/georg-wilhelm-friedrich-hegel-3.jpg";
//        doWork(sms);
//    }

    private static void doWorkDownload(String message) {

        String link = message.split("#")[1];
//            String link = URLEncoder.encode(message.split("#")[1], "UTF-8");
        String cloneFile = getFile(folder, link);
        if (!new File(cloneFile).exists() || new File(cloneFile).length() == 0) {
            Runnable r = new Download(link, cloneFile);
            threadPool.submit(r);
        } else {
            logger.info(" File exist: " + cloneFile);
        }
    }

    private static String getFile(String folder, String link) {
        String cloneFile = folder + link.replace(replaceURL, "");

        if (cloneFile.contains("http://"))
            cloneFile = cloneFile.replace("http://", "");
        if (cloneFile.contains("https://"))
            cloneFile = cloneFile.replace("https://", "");

        return cloneFile;
    }

    private static class Download implements Runnable {

        private String link;
        private String cloneFile;

        public Download(String link, String cloneFile) {
            this.link = link;
            this.cloneFile = cloneFile;
        }

        public void run() {

            try {
                //changed this 2 lines
                URL encodeUrl = new URL(UriUtils.encodePath(link, "UTF-8"));
                InputStream in = encodeUrl.openStream();
                FileUtils.copyToFile(in, new File(cloneFile));

                try {
                    Thread.sleep(sleepDownload * 1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}