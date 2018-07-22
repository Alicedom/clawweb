//package claw.web.data.article;
//
//import claw.web.data.fulldata.Article;
//import claw.web.data.fulldata.DataArticle;
//import claw.web.data.shortdata.DataCategory;
//import Html;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.*;
//
//public class TestGetDataArticle {
//    List<Article> articleList;
//
//    Map<String, String> getCssQueryText3 = new Hashtable<>();
//    List<String> cssSelector;
//    Integer[] len = {1178, 1219, 1301, 1398, 1503, 1541, 1591, 1669, 1802, 1864, 1908};
//    Set bodyExpected = new TreeSet<Integer>(Arrays.asList(len));
//
//    @Before
//    public void setup() throws IOException {
//        Document html = Jsoup.parse(new File("D:\\Documents\\OneDrive\\workspace\\clawweb\\trunk\\web\\src\\test\\java\\claw\\web\\Kênh thời tiết _ Cập nhật tin tức thời tiết 24h.html"), "UTF-8");
//        DataCategory dataCategory1 = new DataCategory(html);
//        String cssSelectorArticle = "#td-outer-wrap > div.td-main-content-wrap.td-main-page-wrap.td-container-wrap > div.td-container.td-pb-article-list > div > div > div > div > div";
//        articleList = dataCategory1.getArticlesOnCategory(cssSelectorArticle, "", "", ""); // not bound
//
//        getCssQueryText3.put("title", "div.td-post-header > header > h1");
//        getCssQueryText3.put("date", "div.td-post-header > header > div");
//        getCssQueryText3.put("source link", "footer > div.td-post-source-tags > div > div > a");
//        getCssQueryText3.put("tag", "footer > div.td-post-source-tags > ul");
//
//        cssSelector = new LinkedList<String>();
//        cssSelector.add("div.td-post-content");
//
//    }
//
//    //    @Test
//    public void setArticle() {
//        Set bodyActual = new TreeSet();
//        for (int i = 0; i < articleList.size(); i++) {
//            Article article = articleList.get(i);
//            System.out.println(article);
//            bodyActual.add(article.getElement().toString().length());
//        }
//        Assert.assertEquals(bodyExpected, bodyActual);
//    }
//
//    //    @Test
//    public void getText() {
//        for (int i = 0; i < articleList.size(); i++) {
//            Article x = articleList.get(i);
//            Document document = Html.getDocument(x.getUrl());
//            DataArticle dataArticle = new DataArticle(x);
//            Map text = dataArticle.setText(document, getCssQueryText3);
//            System.out.println("text.toString() = " + text.toString());
//
//        }
//    }
//
//    //    @Test
//    public void getBody() {
//        articleList.forEach(x -> {
//            Document document = Html.getDocument(x.getUrl());
//            DataArticle dataArticle = new DataArticle(x);
//            Elements length = dataArticle.setBody(document, cssSelector, "");
//
//            System.out.println("body length = " + length);
//        });
//    }
//
//    @Test
//    public void getSrcAndHref() {
//        articleList.forEach(x -> {
//            Document document = Html.getDocument(x.getUrl());
//            DataArticle dataArticle = new DataArticle(x);
//            dataArticle.setBody(document, cssSelector, "");
//            Map map = dataArticle.setHref(dataArticle.getArticle().getContent());
//            List list = dataArticle.setSrc(dataArticle.getArticle().getContent());
//            List url = GetURL.getListHttp(dataArticle.getArticle().getContent().toString());
//            System.out.println("map.size() = " + map.size());
//            System.out.println("list.size() = " + list.size());
//            System.out.println("url.size() = " + url.size());
//            System.out.println("map.toString() = " + map.toString());
//            map.forEach((k, v) -> System.out.println("map.toString() = " + k + ":" + v));
//            System.out.println("list = " + list.toString());
//            System.out.println("url.toString() = " + url.toString());
//        });
//
//        System.out.println("articleList.get(0).getContent().toString() = " + articleList.get(0).getContent().toString());
//    }
//
//}
