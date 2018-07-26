package claw.web.queue;

import claw.web.data.fulldata.Article;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.Calendar;

public class WorkerInsertArticle {

    private final static Logger logger = LoggerFactory.getLogger(WorkerInsertArticle.class);

    private static final String TASK_QUEUE_NAME = "article_queue";
    private static String deliminate = "#";

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
                    logger.info(" [x] Done ");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
    }

    private static void doWorkInsertArticle(String message) {
        try {

            String[] str = message.split(deliminate);
            String source = str[0];
            Article article = new ObjectMapper().readValue(str[1], Article.class);

            int author = 1;
            Date DATE = new Date(Calendar.getInstance().getTimeInMillis());
            String title = article.getTextMap().get("title");
            String sapo = article.getTextMap().get("sapo");
            String content = article.getBody();
            String STATUS = "publish";
            String NAME = null; // convert tu title sang
            int parent = 0;
            String TYPE = "post";
            String origin = null;
            String origin_link = article.getUrl();
            String origin_author = article.getTextMap().get("author");
            String stocks_code = article.getTextMap().get("stocks_code");
            String event_stream = null;
            String picture_link = article.getSrcList().get(0);
            String categoryexp = null;
            String categorylist = null;
            int news_id = 0; // ??? get last
            String news_date = article.getTextMap().get("date");

            insertDataBase(author, DATE, title, sapo, content, STATUS, NAME, parent,
                    TYPE, origin, origin_link, origin_author, stocks_code, event_stream, picture_link, categoryexp, categorylist, news_id, news_date);

            // insert data
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        } catch (JsonParseException e) {
            logger.error(e.getMessage());
        } catch (JsonMappingException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private static void insertDataBase(int author, Date date, String title, String sapo, String content, String status, String name, int parent, String type, String origin, String origin_link, String origin_author, String stocks_code, String event_stream, String picture_link, String categoryexp, String categorylist, int news_id, String news_date) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/wordpress3?useSSL=false";
        String username = "root";
        String password = "123456aA";

        String sql = "{call s(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (java.sql.Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(sql);) {

            // IN author BIGINT
            stmt.setLong(1, author);
            //  IN DATE DATETIME,
            stmt.setDate(2, date);
            //  IN title MEDIUMTEXT,
            stmt.setString(3, title);
            //   IN sapo MEDIUMTEXT,
            stmt.setString(4, sapo);
//            IN content LONGTEXT,
            stmt.setString(5, content);
//                    IN STATUS VARCHAR (20),
            stmt.setString(6, status);
//                    IN NAME VARCHAR (200),
            stmt.setString(7, name);
//                    IN parent BIGINT,
            stmt.setInt(8, parent);
//            IN TYPE VARCHAR (20),
            stmt.setString(9, type);
//                    IN origin VARCHAR (300),
            stmt.setString(10, origin);
//                    IN origin_link VARCHAR (1000),
            stmt.setString(11, origin_link);
//                    IN origin_author VARCHAR (200),
            stmt.setString(12, origin_author);
//                    IN stocks_code VARCHAR (200),
            stmt.setString(13, stocks_code);
//                    IN event_stream VARCHAR (300),
            stmt.setString(14, event_stream);
//                    IN picture_link VARCHAR (1000),
            stmt.setString(15, picture_link);
//                    IN categoryexp TEXT,
            stmt.setString(16, categoryexp);
//            IN categorylist TEXT,
            stmt.setString(17, categorylist);
//                    OUT news_id BIGINT,
//            stmt.setInt(18, news_id);
            stmt.registerOutParameter(18, Types.BIGINT);

//            IN news_date VARCHAR (200)
            stmt.setString(19, news_date);

            stmt.execute();
            logger.info(" [insert] " + stmt.toString());

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}