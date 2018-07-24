package claw.web.queue;

import claw.web.data.shortdata.Utils;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

public class WorkerMedia {

    public static final String folder = "D:\\home\\java\\data\\";
    //    public static final String replaceURL = "http://s1.doc.edu.vn/web/viewer.html?file=http://s1.doc.edu.vn";
    public static final String replaceURL = "http://triethoc.edu.vn/resources/uploaded/TrietHoc/Files/";

    private final static Logger logger = LoggerFactory.getLogger(WorkerMedia.class);
    private static final String TASK_QUEUE_NAME = "src_queue";

//    public static void main(String[] argv) {
//        try {
//            ConnectionFactory factory = new ConnectionFactory();
//            factory.setHost("172.16.9.16");
//            factory.setPort(5672);
//            factory.setUsername("admin");
//            factory.setPassword("123456a@");
//            final Connection connection = factory.newConnection();
//            final Channel channel = connection.createChannel();
//
//            channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);
//            logger.info(" [*] Waiting for messages. To exit press CTRL+C");
//
//
//            channel.basicQos(1);
//
//            final Consumer consumer = new DefaultConsumer(channel) {
//                @Override
//                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                    String message = new String(body, "UTF-8");
//
//                    logger.info(" [x] Received '" + message + "'");
//
//                    try {
//                        doWork(message);
//                    } finally {
//                        logger.info(" [x] Done");
//                        channel.basicAck(envelope.getDeliveryTag(), false);
//                    }
//                }
//            };
//
//            boolean autoAck = false;
//            channel.basicConsume(TASK_QUEUE_NAME, autoAck, consumer);
//
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//        } catch (TimeoutException e) {
//            logger.error(e.getMessage());
//        }
//    }
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        String sms = "http://doc.edu.vn/default.aspx#" +
                "http://triethoc.edu.vn/resources/uploaded/TrietHoc/Files/Thuyết%20Duy%20tâm%20Đức/georg-wilhelm-friedrich-hegel-3.jpg";
        doWork(sms);
    }

    private static void doWork(String message) {


            String link = message.split("#")[1];
//            String link = URLEncoder.encode(message.split("#")[1], "UTF-8");
            String cloneFile = link.replace(replaceURL, folder);

            if (!new File(cloneFile).exists() || new File(cloneFile).length() == 0) {
                Runnable r = new Download(link, cloneFile);
                threadPool.submit(r);
            } else {
                logger.info(" File exist: " + cloneFile);
            }

    }

    private static class Download implements Runnable {

        private String link;
        private String cloneFile;

        public Download(String link, String cloneFile) {
            this.link = link;
            this.cloneFile = cloneFile;
            checkAndCreateNewFile(cloneFile);
        }

        public void run() {
            try {
                URL url = new URL(link);
                System.out.println("url.toString() = " + url.toString());

                InputStream in = new BufferedInputStream(url.openStream());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int n = 0;
                while (-1 != (n = in.read(buf))) {
                    out.write(buf, 0, n);
                }
                out.close();
                in.close();
                byte[] response = out.toByteArray();

                FileOutputStream fos = new FileOutputStream(cloneFile);
                fos.write(response);
                fos.close();
            } catch (MalformedURLException e) {
                logger.error(e.getMessage());
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }

    private static void checkAndCreateNewFile(String file) {
        File log = new File(file);

        if (!log.exists()) {
            try {
                System.out.println("Create: " + file);

                log.getParentFile().mkdirs();
                log.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}