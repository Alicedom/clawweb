//package claw.web.data.entry.html.TestGetHref;
//
//import claw.web.data.entry.element.GetHrefElement;
//import claw.web.data.entry.element.Utils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//public class TestGetHref {
//    Document document1, document2;
//    Elements html, html2;
//    String cssSelector= "#td-outer-wrap > div.td-main-content-wrap.td-main-page-wrap.td-container-wrap > div.td-container.td-pb-article-list > div > div > div > div > div";
//    String cssSelector2="body > div > div > div > div > div > div > div";
//
//
//    @Before
//    public void setup() throws IOException {
//        document1 = Jsoup.parse(new File("D:\\Documents\\OneDrive\\workspace\\clawweb\\trunk\\web\\src\\test\\java\\claw\\web\\Kênh thời tiết _ Cập nhật tin tức thời tiết 24h.html"),"UTF-8");
//        html = document1.children();
//        document2 = Jsoup.parse(new File("D:\\Documents\\OneDrive\\workspace\\clawweb\\trunk\\web\\src\\test\\java\\claw\\web\\categoryselect.html"),"UTF-8");
//        html2 = document2.children();
//
//        String type1="";
//        String type2="a";
//    }
//    @Test
//    public void testMap(){
//        Map list1 = GetHrefElement.getMapHrefRecursives(html,cssSelector,"a","","");
//        System.out.println("list1 = " + list1.size());
//        System.out.println("list1.toString() = " + list1.toString());
//
//    }
//
////    @Test
//    public void getMapHrefRecursives(){
//        Map list1 = GetHrefElement.getMapHrefRecursives(html,cssSelector,"a","","");
//        Map list2 = GetHrefElement.getMapHrefRecursives(html2,cssSelector2,"a","","");
//        Map list3 = GetHrefElement.getMapHrefRecursives(html,cssSelector,"","","");
//        Map list4 = GetHrefElement.getMapHrefRecursives(html2,cssSelector2,"","","");
//        Map list5 = GetHrefElement.getMapHrefRecursives(html,cssSelector,"ascc","","");
//        Map list6 = GetHrefElement.getMapHrefRecursives(html2,null,"","","");
//
//        Element el = null;
//        Map list7 = GetHrefElement.getMapHrefRecursives(el,null,"","","");
//        Elements es = null;
//        Map list8 = GetHrefElement.getMapHrefRecursives(es,null,"","","");
//
////        System.out.println("list1 = " + list1.size());
////        System.out.println("list2 = " + list2.size());
////        System.out.println("list3 = " + list3.size());
////        System.out.println("list4 = " + list4.size());
////
////        System.out.println("list5 = " + list5.size());
////        System.out.println("list6 = " + list6.size());
////        System.out.println("list7 = " + list7.size());
////        System.out.println("list8 = " + list8.size());
//        Assert.assertTrue(list1.size() == 12);
//        Assert.assertTrue(list2.size() == 12);
//        Assert.assertTrue(list3.size() == 12);
//        Assert.assertTrue(list4.size() == 12);
//        Assert.assertTrue(list5.size() == 0);
//        Assert.assertTrue(list6.size() == 15);
//        Assert.assertTrue(list7.size() == 0);
//        Assert.assertTrue(list8.size() == 0);
//    }
//
////    @Test
//    public void getListHrefRecursive2(){
//        List<String> list1 = GetHrefElement.getListHrefRecursives(document1,cssSelector,"a","","");
//        List<String> list2 = GetHrefElement.getListHrefRecursives(document2,cssSelector2,"a","","");
//        List<String> list3 = GetHrefElement.getListHrefRecursives(document1,cssSelector,"","","");
//        List<String> list4 = GetHrefElement.getListHrefRecursives(document2,cssSelector2,"","","");
//        List<String> list5 = GetHrefElement.getListHrefRecursives(document1,cssSelector,"ascc","","");
//        List<String> list6 = GetHrefElement.getListHrefRecursives(document2,null,"","","");
//
//        Document el = null;
//        List<String> list7 = GetHrefElement.getListHrefRecursives(el,null,"","","");
//        Elements es = null;
//        List<String> list8 = GetHrefElement.getListHrefRecursives(es,null,"","","");
//
//        System.out.println("list1 = " + list1.size());
//        System.out.println("list2 = " + list2.size());
//        System.out.println("list3 = " + list3.size());
//        System.out.println("list4 = " + list4.size());
//
//        System.out.println("list5 = " + list5.size());
//        System.out.println("list6 = " + list6.size());
//        System.out.println("list7 = " + list7.size());
//        System.out.println("list8 = " + list8.size());
//        Assert.assertTrue(list1.size() == 24);
//        Assert.assertTrue(list2.size() == 24);
//        Assert.assertTrue(list3.size() == 24);
//        Assert.assertTrue(list4.size() == 24);
//        Assert.assertTrue(list5.size() == 0);
//        Assert.assertTrue(list6.size() == 28);
//        Assert.assertTrue(list7.size() == 0);
//        Assert.assertTrue(list8.size() == 0);
//
//
//        System.out.println("list4 remove duplicate link = " + Utils.removeDuplicate(list4).size());
//        System.out.println("list6 remove duplicate link = " + Utils.removeDuplicate(list6).size());
//        Assert.assertTrue(Utils.removeDuplicate(list4).size() == 12);
//        Assert.assertTrue(Utils.removeDuplicate(list6).size() == 15);
//
//    }
//
////    @Test
//    public void getListHrefRecursives(){
//        List<String> list1 = GetHrefElement.getListHrefRecursives(html,cssSelector,"a","","");
//        List<String> list2 = GetHrefElement.getListHrefRecursives(html2,cssSelector2,"a","","");
//        List<String> list3 = GetHrefElement.getListHrefRecursives(html,cssSelector,"","","");
//        List<String> list4 = GetHrefElement.getListHrefRecursives(html2,cssSelector2,"","","");
//        List<String> list5 = GetHrefElement.getListHrefRecursives(html,cssSelector,"ascc","","");
//        List<String> list6 = GetHrefElement.getListHrefRecursives(html2,null,"","","");
//
//        Document el = null;
//        List<String> list7 = GetHrefElement.getListHrefRecursives(el,null,"","","");
//        Elements es = null;
//        List<String> list8 = GetHrefElement.getListHrefRecursives(es,null,"","","");
//
//
//        Assert.assertTrue(list1.size() == 24);
//        Assert.assertTrue(list2.size() == 24);
//        Assert.assertTrue(list3.size() == 24);
//        Assert.assertTrue(list4.size() == 24);
//        Assert.assertTrue(list5.size() == 0);
//        Assert.assertTrue(list6.size() == 28);
//        Assert.assertTrue(list7.size() == 0);
//        Assert.assertTrue(list8.size() == 0);
//
//
//        System.out.println("list4 remove duplicate link = " + Utils.removeDuplicate(list4).size());
//        System.out.println("list6 remove duplicate link = " + Utils.removeDuplicate(list6).size());
//        Assert.assertTrue(Utils.removeDuplicate(list4).size() == 12);
//        Assert.assertTrue(Utils.removeDuplicate(list6).size() == 15);
//    }
//}
