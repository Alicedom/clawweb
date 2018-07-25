package claw.web.test;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.util.UriUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class TestJsoupUTF8src {
    public static void main(String[] args) throws IOException {
//        Document document = Jsoup.connect("http://triethoc.edu.vn/vi/chuyen-de-triet-hoc/nhap-mon-triet-hoc/ban-tinh-cua-chan-ly-triet-hoc-va-phuong-phap-cua-no_843.html").get();
//        System.out.println("document = " + document.select("img[src$=hegel-3.jpg]").attr("src"));

        String url = "http://triethoc.edu.vn/resources/uploaded/TrietHoc/Files/Thuyết Duy tâm Đức/georg-wilhelm-friedrich-hegel-3.jpg";

        String folder = "D:\\Documents\\";
        String file = "a.jpg";
        download(url, folder+file);
//        File f =  new File(url);
//        String encodstring = encodeFileToBase64Binary(f);
//        System.out.println(encodstring);
    }

//    private static String encodeFileToBase64Binary(File file){
//        String encodedfile = null;
//        try {
//            FileInputStream fileInputStreamReader = new FileInputStream(file);
//            byte[] bytes = new byte[(int)file.length()];
//            fileInputStreamReader.read(bytes);
//            encodedfile = Base64.encodeBase64(bytes).toString();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return encodedfile;
//    }

    public static void download(String url,String filename){

        try {
            //changed this 2 lines
            URL encodeUrl = new URL(UriUtils.encodePath(url, "UTF-8"));
            InputStream in = encodeUrl.openStream();
            FileUtils.copyToFile(in, new File(filename));

            try {
                Thread.sleep(1*1000);
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
