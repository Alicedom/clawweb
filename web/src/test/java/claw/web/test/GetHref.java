package claw.web.test;

import claw.web.data.entry.Href;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GetHref {
    public static void main(String[] args) {
        String url = "D:\\Documents\\OneDrive\\workspace\\clawweb\\branches\\claw2\\web\\src\\test\\java\\claw\\web\\Tài liệu, ebook, giáo trình, đồ án, luận văn.html";
        try {
            Document document = Jsoup.parse(new File(url), "UTF-8");
            String cssSelector = "#documents > div.box > ul > li";
            List<String> list = Href.getListHrefRecursives(document,cssSelector,"a","tai","");
            System.out.println("list = " + list.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
