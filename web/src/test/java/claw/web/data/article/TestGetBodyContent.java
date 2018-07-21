package claw.web.data.article;

import claw.web.data.entry.element.GetHrefElement;
import claw.web.data.entry.html.GetURL;
import claw.web.data.fulldata.Article;
import claw.web.data.fulldata.DataArticle;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestGetBodyContent {
    Article article;
    DataArticle dataArticle;
    Document document;
    @Before
    public void setup() throws IOException {
        document = Jsoup.parse(new File("D:\\Documents\\OneDrive\\workspace\\clawweb\\trunk\\web\\src\\test\\java\\claw\\web\\body1.html"), "UTF-8");
        article = new Article("");
        article.setContent(document.children());
        dataArticle = new DataArticle(article);
    }

    @Test
    public void getDataContent(){
        Map map = dataArticle.setHref(document.children());
        List list = dataArticle.setSrc(document.children());
        List url = GetURL.getListHttp(document.toString());
        System.out.println("map.size() = " + map.size());
        System.out.println("list.size() = " + list.size());
        System.out.println("url.size() = " + url.size());
        System.out.println("map.toString() = " + map.toString());
        map.forEach((k,v)-> System.out.println("map.toString() = " + k+":"+ v));
        System.out.println("list = " + list.toString());
        System.out.println("url.toString() = " + url.toString());
    }

    @Test
    public void testGetURL(){
        Map list1 = GetHrefElement.getMapHrefRecursives(document,"","a","","");
        System.out.println("list1 = " + list1.size());
        System.out.println("list1.toString() = " + list1.toString());

    }
}
