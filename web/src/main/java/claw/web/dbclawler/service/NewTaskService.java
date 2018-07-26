package claw.web.dbclawler.service;

import claw.web.data.connect.Html;
import claw.web.data.entry.Href;
import claw.web.dbclawler.entity.Entry;
import claw.web.dbclawler.repository.EntryFilterRepository;
import claw.web.dbclawler.repository.EntryRepository;
import claw.web.queue.NewTask;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class NewTaskService {
    private final static Logger logger = LoggerFactory.getLogger(NewTask.class);

    private static final String TASK_QUEUE_NAME = "url_queue";
    private static final String deliminate = "#";

    @Autowired
    EntryRepository entryRepository;

    @Autowired
    EntryFilterRepository entryFilterRepository;

    public void startGetEntry() {
        Runnable runnable = new EntryRunnable();
        ScheduledExecutorService darkService = Executors.newScheduledThreadPool(5);
        darkService.scheduleWithFixedDelay(runnable, 0, 5, TimeUnit.MINUTES);
    }

    private void sendEntry(int entryId, List<String> listURL) {
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
                            (entryId + deliminate + x).getBytes());
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

    private class EntryRunnable implements Runnable {

        public void run() {

            List<Entry> list = entryRepository.findAllByActivedTrue();
            for (Entry x : list) {
                Document document = Html.getDocument(x.getUrlCategory());
                List<String> include = entryFilterRepository.findAllByEntryIdAndSelectedIsTrue(x.getEntryId());
                List<String> exclude = entryFilterRepository.findAllByEntryIdAndSelectedIsFalse(x.getEntryId());

                List<String> listURL = Href.getListHrefRecursives(document, x.getCssSelector(), x.getType(), include, exclude);

                sendEntry(x.getEntryId(), listURL);
            }
        }


    }
}
