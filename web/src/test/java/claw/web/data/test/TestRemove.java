package claw.web.data.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class TestRemove {
    public static void main(String[] args) {
        String html = "<body><a></a><b></b></c></body>";
        Document document = Jsoup.parse(html);

        document.select("a").remove();
        System.out.println("document = " + document);
    }
}
