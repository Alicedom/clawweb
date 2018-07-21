package claw.web.data.entry.html.TestGetSrc;

import claw.web.data.entry.element.GetSrcElement;
import claw.web.data.entry.element.Utils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestGetSrcElement {
    Document document, document2;
    String cssSelector= "#td-outer-wrap > div.td-main-content-wrap.td-main-page-wrap.td-container-wrap > div.td-container.td-pb-article-list > div > div > div > div > div";
    String cssSelector2="body > div > div > div > div > div > div > div";


    @Before
    public void setup() throws IOException {
        document = Jsoup.parse(new File("D:\\Documents\\OneDrive\\workspace\\clawweb\\trunk\\web\\src\\test\\java\\claw\\web\\Kênh thời tiết _ Cập nhật tin tức thời tiết 24h.html"),"UTF-8");
        document2 = Jsoup.parse(new File("D:\\Documents\\OneDrive\\workspace\\clawweb\\trunk\\web\\src\\test\\java\\claw\\web\\categoryselect.html"),"UTF-8");

    }

    @Test
    public void getFirstSource(){
        String src0 = GetSrcElement.getFirstSource(null,"");

        String src1 = GetSrcElement.getFirstSource(document,"");
        String src2 = GetSrcElement.getFirstSource(document2,"");

        String src3 = GetSrcElement.getFirstSource(document,"img");
        String src4 = GetSrcElement.getFirstSource(document2,"img");

        System.out.println("src0 = " + src0);
        System.out.println("src1 = " + src1);
        System.out.println("src2 = " + src2);
        System.out.println("src3 = " + src3);
        System.out.println("src4 = " + src4);

        Assert.assertEquals(src0,null);
        Assert.assertEquals(src1,"http://kenhthoitiet.am.local/wp-includes/js/jquery/jquery.js?ver=1.12.4");
        Assert.assertEquals(src2,"http://kenhthoitiet.am.local/wp-content/uploads/2018/07/ava_65_nguoi_chet_vi_nang_nong_o_pakistan-324x160.jpg");
        Assert.assertEquals(src3,"http://kenhthoitiet.am.local/wp-content/uploads/2018/07/logo_mobile.png");
        Assert.assertEquals(src4,"http://kenhthoitiet.am.local/wp-content/uploads/2018/07/ava_65_nguoi_chet_vi_nang_nong_o_pakistan-324x160.jpg");
    }

    @Test
    public void getFirstSourceElements(){
        Elements src0 = GetSrcElement.getFirstSourceElements(null,"");
        Elements src1 = GetSrcElement.getFirstSourceElements(document,"");
        Elements src2 = GetSrcElement.getFirstSourceElements(document2,"");

        Elements src3 = GetSrcElement.getFirstSourceElements(document,"img");
        Elements src4 = GetSrcElement.getFirstSourceElements(document2,"img");

        System.out.println("src0 = " + src0.size());
        System.out.println("src1 = " + src1.size());
        System.out.println("src2 = " + src2.size());
        System.out.println("src3 = " + src3.size());
        System.out.println("src4 = " + src4.size());
        Assert.assertTrue(src0.size() == 0);
        Assert.assertTrue(src1.size() == 81);
        Assert.assertTrue(src2.size() == 16);
        Assert.assertTrue(src3.size() == 75);
        Assert.assertTrue(src4.size() == 16);

    }

    @Test
    public void getListAllSource(){
        List src0 = GetSrcElement.getListOneSource(null,cssSelector,"");
        List src1 = GetSrcElement.getListOneSource(document,null,"");
        List src2 = GetSrcElement.getListOneSource(document,"","");

        List src3 = GetSrcElement.getListOneSource(document,cssSelector,"");
        List src4 = GetSrcElement.getListOneSource(document2,cssSelector2,"");

        List src5 = GetSrcElement.getListOneSource(document,cssSelector,"img");
        List src6 = GetSrcElement.getListOneSource(document2,cssSelector2,"img");

        Assert.assertTrue(src0.size() == 0);
        Assert.assertTrue(src1.size() == 0);
        Assert.assertTrue(src2.size() == 0);
        Assert.assertTrue(src3.size() == 13);
        Assert.assertTrue(src4.size() == 12);
        Assert.assertTrue(src5.size() == 13);
        Assert.assertTrue(src6.size() == 12);

        Assert.assertTrue(Utils.removeDuplicate(src5).size() == 12);
        Assert.assertTrue(Utils.removeDuplicate(src6).size() == 12);
    }

    @Test
    public void getListAllSourceElements(){
        List src0 = GetSrcElement.getListOneSourceElements(null,cssSelector,"");
        List src1 = GetSrcElement.getListOneSourceElements(document,null,"");
        List src2 = GetSrcElement.getListOneSourceElements(document,"","");

        List src3 = GetSrcElement.getListOneSourceElements(document,cssSelector,"");
        List src4 = GetSrcElement.getListOneSourceElements(document2,cssSelector2,"");

        List src5 = GetSrcElement.getListOneSourceElements(document,cssSelector,"img");
        List src6 = GetSrcElement.getListOneSourceElements(document2,cssSelector2,"img");

        Assert.assertTrue(src0.size() == 0);
        Assert.assertTrue(src1.size() == 0);
        Assert.assertTrue(src2.size() == 0);
        Assert.assertTrue(src3.size() == 16);
        Assert.assertTrue(src4.size() == 16);
        Assert.assertTrue(src5.size() == 16);
        Assert.assertTrue(src6.size() == 16);
    }


    @Test
    public void getListAllSourceRecursive(){
        List src0 = GetSrcElement.getListAllSourceRecursive(null,cssSelector,"");
        List src1 = GetSrcElement.getListAllSourceRecursive(document,null,"");
        List src2 = GetSrcElement.getListAllSourceRecursive(document,"","");

        List src3 = GetSrcElement.getListAllSourceRecursive(document,cssSelector,"");
        List src4 = GetSrcElement.getListAllSourceRecursive(document2,cssSelector2,"");

        List src5 = GetSrcElement.getListAllSourceRecursive(document,cssSelector,"img");
        List src6 = GetSrcElement.getListAllSourceRecursive(document2,cssSelector2,"img");

        Assert.assertTrue(src0.size() == 0);
        Assert.assertTrue(src1.size() == 0);
        Assert.assertTrue(src2.size() == 0);
        Assert.assertTrue(src3.size() == 16);
        Assert.assertTrue(src4.size() == 16);
        Assert.assertTrue(src5.size() == 16);
        Assert.assertTrue(src6.size() == 16);
    }

    @Test
    public void getListAllSourceRecursiveElements(){
        List src0 = GetSrcElement.getListAllSourceRecursiveElements(null,cssSelector,"");
        List src1 = GetSrcElement.getListAllSourceRecursiveElements(document,null,"");
        List src2 = GetSrcElement.getListAllSourceRecursiveElements(document,"","");

        List src3 = GetSrcElement.getListAllSourceRecursiveElements(document,cssSelector,"");
        List src4 = GetSrcElement.getListAllSourceRecursiveElements(document2,cssSelector2,"");

        List src5 = GetSrcElement.getListAllSourceRecursiveElements(document,cssSelector,"img");
        List src6 = GetSrcElement.getListAllSourceRecursiveElements(document2,cssSelector2,"img");

        Assert.assertTrue(src0.size() == 0);
        Assert.assertTrue(src1.size() == 0);
        Assert.assertTrue(src2.size() == 0);
        Assert.assertTrue(src3.size() == 16);
        Assert.assertTrue(src4.size() == 16);
        Assert.assertTrue(src5.size() == 16);
        Assert.assertTrue(src6.size() == 16);
    }

    @Test
    public void getListAllSourceRecursiveElements2() {
        Elements src0 = GetSrcElement.getListAllSourceRecursiveElements(null,cssSelector2,"");
        Elements src1 = GetSrcElement.getListAllSourceRecursiveElements(document2,null,"");
        Elements src2 = GetSrcElement.getListAllSourceRecursiveElements(document2,"","");

        Elements src3 = GetSrcElement.getListAllSourceRecursiveElements(document,cssSelector,"");
        Elements src4 = GetSrcElement.getListAllSourceRecursiveElements(document2,cssSelector2,"");

        Elements src5 = GetSrcElement.getListAllSourceRecursiveElements(document,cssSelector,"img");
        Elements src6 = GetSrcElement.getListAllSourceRecursiveElements(document2,cssSelector2,"img");

        Assert.assertTrue(src0.size() == 0);
        Assert.assertTrue(src1.size() == 0);
        Assert.assertTrue(src2.size() == 0);
        Assert.assertTrue(src3.size() == 16);
        Assert.assertTrue(src4.size() == 16);
        Assert.assertTrue(src5.size() == 16);
        Assert.assertTrue(src6.size() == 16);
    }

}
