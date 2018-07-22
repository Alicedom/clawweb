package claw.web.data.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class ReplaceHrefAndSrc {

    public static void main(String[] args) throws IOException {

        String file = "D:\\Documents\\OneDrive\\workspace\\clawweb\\trunk\\web\\src\\test\\java\\claw\\web\\test\\srcAndHrefTest.html";

        Document document = Jsoup.parse(new File(file), "UTF-8");
        document.select("a[href]").attr("href", "http://nofollow");
        System.out.println("document = " + document);



    }
}
