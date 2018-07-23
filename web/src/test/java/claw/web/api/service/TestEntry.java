package claw.web.api.service;

import claw.web.data.fulldata.Article;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestEntry {
    String url = "http://triethoc.edu.vn";
    String css= "div > div.page-wrapper.home-wrapper > div> div > ul > li > div";
//    @Autowired

    Entry entry ;

    @Before
    public void setup(){
        entry = new Entry();;
    }

    @Test
    public void testConnect(){
        Document document = entry.connect(url, null, null, 0, null);
        List<Article> list = entry.getShortData(css,null,  null, "");
        list.forEach(System.out::println);
    }
}
