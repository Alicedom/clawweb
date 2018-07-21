package claw.web.data.entry.html.TestGetURL;

import claw.web.data.entry.html.GetURL;
import org.jsoup.Jsoup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestgetListAttrStartWith {
    String html;
    String att1= "http://";
    String att2= "https://";

    @Before
    public void setup() throws IOException {
        html = Jsoup.parse(new File("D:\\Documents\\OneDrive\\workspace\\clawweb\\trunk\\web\\src\\test\\java\\claw\\web\\Kênh thời tiết _ Cập nhật tin tức thời tiết 24h.html"),"UTF-8").toString();

    }
    @Test
    public void get1() throws IOException {
        List<String> url = GetURL.getListAttrStartWith(html,att1);
        System.out.println("url.size() = " + url.size());
        url.forEach(System.out::println);

        Assert.assertTrue(url.size() == 369);
    }

    @Test
    public void get2() throws IOException {
        List<String> url = GetURL.getListAttrStartWith(html,att2);
        Assert.assertTrue(url.size() == 2);
        System.out.println("url.size() = " + url.size());
        url.forEach(System.out::println);
    }

    @Test
    public void getHttp() throws IOException {
        List<String> url = GetURL.getListHttp(html);
        System.out.println("url.size() = " + url.size());
        url.forEach(System.out::println);

        Assert.assertTrue(url.size() == 369);
    }
}
