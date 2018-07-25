package claw.web.queue;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class WorkerInsertArticle {

    private final static Logger logger = LoggerFactory.getLogger(WorkerInsertArticle.class);

    private static final String TASK_QUEUE_NAME = "article_queue";

    public static void main(String[] argv) throws Exception {
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

//                logger.info(" [x] Received '" + message + "'");

                try {
                    doWorkInsertArticle(message);
                } finally {
                    logger.info(" [x] Done " + message);
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
    }

    private static void doWorkInsertArticle(String message) {
        try {

            // insert data
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}