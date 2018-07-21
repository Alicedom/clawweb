package claw.web.data.entry.html;

import claw.web.data.entry.element.GetAttrElement;
import org.jsoup.Jsoup;

import java.util.LinkedList;
import java.util.List;

public class GetAttr {

    public static String getFirstHref(String html, String css, String attr) {
        String url = null;

        if (html == null) {
            // html null
        } else {
            url = GetAttrElement.getFirstHref(Jsoup.parse(html),css,attr);
        }

        return url;
    }

    public static List<String> getListHref(String html, String cssSelector, String css, String attr) {
        List<String> list = new LinkedList<>();

        if (cssSelector == null || html == null) {
            // html null
        } else {
            list = GetAttrElement.getListHref(Jsoup.parse(html),cssSelector,css,attr);
        }

        return list;
    }

    public static List<String> getListHrefRecursive(String html, String css, String attr) {
        List listHrefLink = new LinkedList();

        if (html == null) {
            // html null
        } else {

            listHrefLink = GetAttrElement.getListHrefRecursive(Jsoup.parse(html),css,attr);
        }
        return listHrefLink;
    }

    public static List<String> getListHrefRecursive(String html, String cssSelector, String css, String attr) {
        List listHrefLink = new LinkedList();

        if (html == null) {
            // html null
        } else {

            listHrefLink = GetAttrElement.getListHrefRecursive(Jsoup.parse(html),cssSelector,css,attr);
        }
        return listHrefLink;
    }
}
//                String str = y.attr(attr);
//                if (str == null
//                        || (include != null && !include.equals("") && !str.contains(include))
//                        || (exclude != null && !exclude.equals("") && str.contains(exclude))) {
//                    //url get null
//                } else {
//                    listHrefLink.add(str);
//                }