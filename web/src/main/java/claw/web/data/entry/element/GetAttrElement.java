package claw.web.data.entry.element;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;

public class GetAttrElement {

    public static String getFirstHref(Element html, String css, String attr) {

        if (html == null) {
            return null;
        } else {
            return  html.select(css + "[" + attr + "]").attr(attr);
        }

    }

    public static Elements getFirstHrefElements(Element html, String css, String attr) {

        if (html == null) {
            return null;
        } else {
            return html.select(css + "[" + attr + "]");
        }
    }

    public static Elements getListHrefElements(Element html, String cssSelector, String css, String attr) {

        if (cssSelector == null || html == null) {
            return null;
        } else {
            return html.select(cssSelector).select(css + "[" + attr + "]");

        }
    }

    public static List<String> getListHref(Element html, String cssSelector, String css, String attr) {
        List<String> list = new LinkedList<>();

        if (cssSelector == null || html == null) {
            // html null
        } else {
            html.select(cssSelector).forEach(x -> {
                list.add(x.select(css + "[" + attr + "]").attr(attr));
            });
        }

        return list;
    }

    public static List<String> getListHrefRecursive(Element html, String css, String attr) {
        List listHrefLink = new LinkedList();

        if (html == null) {
            // html null
        } else {

            html.select(css + "[" + attr + "]").forEach(y -> {
                listHrefLink.add(y.attr(attr));
            });
        }
        return listHrefLink;
    }

    public static List<String> getListHrefRecursive(Element html, String cssSelector, String css, String attr) {
        List listHrefLink = new LinkedList();

        if (html == null) {
            // html null
        } else {

            html.select(cssSelector).select(css + "[" + attr + "]").forEach(y -> {
                listHrefLink.add(y.attr(attr));
            });
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