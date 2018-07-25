package claw.web.img;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

/*
2 cach Download,  cho 14 File
cach 1, tra ve 30MB
cach 2, png tra ve 113MB
cach 2, jpg tra ve 19,5MB
do phan giai bang nhau
 */
public class CloneImage {

    private String homeLink;
    private String dataListLink;
    private String homeImageLink;
    private String oldLink;
    private String removeLink;
    private String dataFolder;
    private String logFile;


    public CloneImage(String initHomeLink, String dataListLink, String initOldLink, String initRemoveLink, String initDataFolder, String initLogFile) {
        this.homeLink = initHomeLink;
        this.dataListLink = dataListLink;
        this.oldLink = initOldLink;
        this.removeLink = initRemoveLink;
        this.dataFolder = initDataFolder;
        this.logFile = initLogFile;

    }

    public CloneImage(String initHomeLink, String dataListLink, String initHomeImageLink, String initOldLink, String initRemoveLink, String initDataFolder, String initLogFile) {
        this.homeLink = initHomeLink;
        this.dataListLink = dataListLink;
        this.oldLink = initOldLink;
        this.removeLink = initRemoveLink;
        this.dataFolder = initDataFolder;
        this.logFile = initLogFile;
        this.homeImageLink = initHomeImageLink;

    }

    public void getData(String cssSelectorListLink, String cssSelectorImage) {

        try {
            checkAndCreateNewFile(dataFolder + logFile);

            Document doc = Jsoup.connect(dataListLink).timeout(30000).get();
            Elements liList = doc.select(cssSelectorListLink);
            System.out.println("Get number link: " + liList.size());

            int iFile = 0;
            for (; iFile < liList.size(); iFile++) {

                String link = liList.get(iFile).select("a").attr("href");
                if (!link.contains("http://") || !link.contains(homeLink))
                    link = homeLink + link;
                link = link.replace("\\","/");
                System.out.println("Link data: " + link);

                //take image link
                if(cssSelectorImage != null){
                    doc = Jsoup.connect(link).timeout(30000).get();
                    link = homeImageLink+doc.select(cssSelectorImage).select("img").attr("src");
                    System.out.println("Link image: "+link);
                }

                if (link.equals(oldLink)) {
                    break;
                } else if( link.contains(".jpg") || link.contains(".png")) {
                    System.out.println("pass link:"+link);
                    String cloneFile = dataFolder + link.replace(removeLink, "");
                    checkAndCreateNewFile(cloneFile);
                    this.downloadImageFromLink(link, cloneFile);
                    Files.write(Paths.get(dataFolder + logFile), link.getBytes(), StandardOpenOption.APPEND);

                }else{

                    System.out.println("Fail link: "+link);
                    continue;

                }
            }
            System.out.println("Number new file content: " + (iFile + 1));

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void getData(String cssSelectorListLink) {
        getData(cssSelectorListLink, null);
    }

    private void downloadImageFromLink(String link, String cloneFile) {
        Runnable r = new DownloadImage1(link, cloneFile);
        new Thread(r).start();

    }

    public static void main(String[] args) {
        String url1 = "http://triethoc.edu.vn\\resources\\uploaded\\TrietHoc\\Files\\Danh%20nhan%20triet%20hoc\\2018-0000-67878.jpg";
        String url2 = "http://triethoc.edu.vn/resources/uploaded/TrietHoc/Files/Thuyết Duy tâm Đức/georg-wilhelm-friedrich-hegel-3.jpg";

        new DownloadImage1(url2,
                "D:\\Download\\asd.jpg").run();
//        Image image = null;
//        try {
//            URL url = new URL(url2);
//            image = ImageIO.read(url);
//
//        } catch (IOException e) {
//        }
    }

    private static class DownloadImage1 implements Runnable {

        private String link;
        private String cloneFile;
        public DownloadImage1(String link, String cloneFile) {
            this.link=link;
            this.cloneFile = cloneFile;
        }

        public void run() {
            URL url;
            try {
                url = new URL("http://triethoc.edu.vn/resources/uploaded/TrietHoc/Files/Thuy%E1%BA%BFt%20Duy%20t%C3%A2m%20%C4%90%E1%BB%A9c/georg-wilhelm-friedrich-hegel-3.jpg");

                String url1= "http://triethoc.edu.vn/resources/uploaded/TrietHoc/Files/Thuyết Duy tâm Đức/georg-wilhelm-friedrich-hegel-3.jpg";
// url = new URL(java.net.URLEncoder.encode(link, "UTF-8").replace("%3A",":").replace("%2F","/"));
                System.out.println(java.net.URLEncoder.encode(url1, "UTF-8").replace("%3A",":").replace("%2F","/"));
                System.out.println(new String(url1.getBytes("UTF-8"),"ASCII"));
//                System.out.println(Base64.getEncoder().encodeToString(url1.getBytes()));
//                System.out.println(Base64.getDecoder().decode(url1));
                System.out.println(url.toString());

                InputStream in = new BufferedInputStream(new URL(url1).openStream());
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
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private class DownloadImage2 implements Runnable {

        private String link;
        private String cloneFile;

        public DownloadImage2(String link, String cloneFile) {
            this.link=link;
            this.cloneFile=cloneFile;
        }

        public void run() {
            BufferedImage image = null;
            try{

                URL url = new URL(link);
                image = ImageIO.read(url);
                ImageIO.write(image, "jpg", new File(cloneFile));


            } catch (MalformedURLException e) {
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }



    private void checkAndCreateNewFile(String file) {
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
