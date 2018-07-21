package claw.web.data.category;

import claw.web.data.shortdata.DataCategory;
import claw.web.data.connect.Html;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestDataCategorygetEntriesOnCategory {

    String homelink = "http://kenhthoitiet.am.local/tin-tuc/";
    String css1 = "#td-outer-wrap > div.td-main-content-wrap.td-container-wrap > div > div > div > div > div";
    String css2 = "#td-outer-wrap > div.td-main-content-wrap.td-container-wrap > div > div > div > div";
    String cssSmall1 = "#td-outer-wrap > div.td-main-content-wrap.td-container-wrap > div > div > div > div > div > div > div.td-module-image > div > a";
    String include = "tin-tuc";
    String exclude = "/page/";

    String doc = Html.getDocument(homelink).toString();
    Document document = Html.getDocument(homelink);
    DataCategory category = new DataCategory(document.toString(), 4, 20);

    Document html, html2;
    String cssSelector = "#td-outer-wrap > div.td-main-content-wrap.td-main-page-wrap.td-container-wrap > div.td-container.td-pb-article-list > div > div > div > div > div";
    String cssSelector2 = "body > div > div > div > div > div > div > div";

    DataCategory dataCategory1, dataCategory2, dataCategory3, dataCategory4, dataCategory5;

    @Before
    public void setup() throws IOException {
        html = Jsoup.parse(new File("D:\\Documents\\OneDrive\\workspace\\clawweb\\trunk\\web\\src\\test\\java\\claw\\web\\Kênh thời tiết _ Cập nhật tin tức thời tiết 24h.html"), "UTF-8");
        html2 = Jsoup.parse(new File("D:\\Documents\\OneDrive\\workspace\\clawweb\\trunk\\web\\src\\test\\java\\claw\\web\\categoryselect.html"), "UTF-8");

        String type1 = "";
        String type2 = "a";
        dataCategory1 = new DataCategory(html);
        dataCategory2 = new DataCategory(html2);
        dataCategory3 = new DataCategory(html, 4, 50);
        dataCategory4 = new DataCategory(html2, 4, 20);
        dataCategory5 = new DataCategory(html2, 5, 4);
    }

    @Test
    public void getEntry() {
        List list1 = dataCategory1.getEntriesOnCategory(cssSelector, "", ""); // not bound
        List list2 = dataCategory2.getEntriesOnCategory(cssSelector2, "", ""); // not bound
        List list3 = dataCategory3.getEntriesOnCategory(cssSelector, "", ""); //bound
        List list4 = dataCategory4.getEntriesOnCategory(cssSelector2, "", ""); //bound
        List list5 = dataCategory5.getEntriesOnCategory(cssSelector2, "", ""); //wrong bound
        List list6 = dataCategory5.getEntriesOnCategory(cssSelector, "", ""); //wrong css
        list1.forEach(System.out::println);
        Assert.assertTrue(list1.size() == 12);
        Assert.assertTrue(list2.size() == 12);
        Assert.assertTrue(list3.size() == 12);
        Assert.assertTrue(list4.size() == 12);
        Assert.assertTrue(list5.size() == 0);
        Assert.assertTrue(list6.size() == 0);

    }

    @Test
    public void getElement() {
        List list1 = dataCategory1.getElementsOnCategory(cssSelector); // not bound
        List list2 = dataCategory2.getElementsOnCategory(cssSelector2); // not bound
        List list3 = dataCategory3.getElementsOnCategory(cssSelector); //bound
        List list4 = dataCategory4.getElementsOnCategory(cssSelector2); //bound
        List list5 = dataCategory5.getElementsOnCategory(cssSelector2); //wrong bound
        List list6 = dataCategory5.getElementsOnCategory(cssSelector); //wrong css

        System.out.println("list1 = " + list1.size());
        System.out.println("list2 = " + list2.size());
        System.out.println("list3 = " + list3.size());
        System.out.println("list4 = " + list4.size());
        System.out.println("list5 = " + list5.size());
        System.out.println("list6 = " + list6.size());

    }

    @Test
    public void getElement1() {
        List list1 = dataCategory1.getElementsOnCategory(cssSelector); // not bound
        System.out.println("list1 = " + list1.size());
    }

    @Test
    public void getElement2() {
        List list2 = dataCategory2.getElementsOnCategory(cssSelector2); // not bound
        System.out.println("list2 = " + list2.size());
    }

    @Test
    public void getElement3() {
        List list3 = dataCategory3.getElementsOnCategory(cssSelector); //bound
        System.out.println("list3 = " + list3.size());
    }

    @Test
    public void getElement4() {
        List list4 = dataCategory4.getElementsOnCategory(cssSelector2); //bound
        System.out.println("list4 = " + list4.size());
    }

    @Test
    public void getElement5() {
        List list5 = dataCategory5.getElementsOnCategory(cssSelector2); //wrong bound
        System.out.println("list5 = " + list5.size());
    }

    @Test
    public void getElement6() {
        List list6 = dataCategory5.getElementsOnCategory(cssSelector); //wrong css
        System.out.println("list6 = " + list6.size());
    }

}
