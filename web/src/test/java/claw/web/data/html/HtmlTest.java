package claw.web.data.html;
import claw.web.data.connect.Html;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class HtmlTest {
    String url = "https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html";
    int timeout = 3000;

    @Test
    public void exampleTest() {
        Document doc = Html.getDocument(url);
        System.out.println(doc.outerHtml().length());
    }


    @Test
    public void exampleTest2() {
        Document doc = Html.getDocument(url,timeout);
        System.out.println(doc.outerHtml().length());
    }
}
