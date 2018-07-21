package claw.web.media;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;


public class Download {

    private static final Logger logger = LoggerFactory.getLogger(Download.class);

    private class DownloadFileCallable implements Callable<String> {

        private String link;
        private String fileName;

        public DownloadFileCallable(String link, String file) {
            this.link = link;
            this.fileName = file;
        }

        public String call() {
            try {

                checkAndCreateNewFile(fileName);
                ReadableByteChannel rbc = Channels.newChannel(new URL(link).openStream());
                FileOutputStream fos = new FileOutputStream(fileName);
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

            } catch (IOException e) {
                logger.error(e.getMessage());
            }
            return fileName;
        }
    }

    private void checkAndCreateNewFile(String saveDir) {
        File log = new File(saveDir);

        if (log.getParentFile() != null && !log.getParentFile().exists()) {
            log.getParentFile().mkdirs();
        }
        if (!log.exists()) {
            try {
                log.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
