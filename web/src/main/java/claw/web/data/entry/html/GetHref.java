package claw.web.data.entry.html;

import claw.web.data.entry.element.GetHrefElement;
import org.jsoup.Jsoup;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GetHref {
    public static List<String> getListHrefRecursives(String html, String cssSelector, String type, String include, String exclude){
        if(html == null || html.equals("")){
            return new LinkedList();
        }else{
            return GetHrefElement.getListHrefRecursives( Jsoup.parse(html),  cssSelector,  type,  include,  exclude);
        }
    }

    public static Map<String, String> getMapHrefRecursives(String html, String cssSelector, String type, String include, String exclude){
        return GetHrefElement.getMapHrefRecursives( Jsoup.parse(html),  cssSelector,  type,  include,  exclude);
    }


}
