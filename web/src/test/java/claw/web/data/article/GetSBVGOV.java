package claw.web.data.article;

import claw.web.data.shortdata.DataCategory;
import claw.web.data.connect.Html;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class GetSBVGOV {
    String cssSelectURL=" tbody > tr > td:nth-child(3) > div > div > div:nth-child(2) > div > div > div > div > span > ul > li";
    String getCssSelectURL2 = " div.text-menu";
    List<String> listentries;
    @Before
    public void setup() throws IOException {

    }

    @Test
    public void getsbv(){
        String url= "https://www.sbv.gov.vn/webcenter/portal/vi/menu/trangchu";
        Element doc = Html.getDocument(url,30000);
        System.out.println("doc.toString() = " + doc.toString().substring(0,100));


        DataCategory dataCategory1 = new DataCategory(doc);
        listentries = dataCategory1.getEntriesOnCategory(getCssSelectURL2,"","");
        Elements e = dataCategory1.getElementsOnCategory(getCssSelectURL2);
        System.out.println("e.toString() = " + e.toString());
        System.out.println(listentries.toString());
    }

}
