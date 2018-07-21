package claw.web.data.entry.element;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;

/*
get all link a href and link src from html
(recursive) : an element of html can give many link/url
 */
public class GetSrcElement {

    /*
    get first src
     */
    public static String getFirstSource(Element html, String type) {

        if (html == null) {
            return null;
        } else {
            return html.select(type + "[src]").attr("src");
        }

    }

    public static Elements getFirstSourceElements(Element html, String type) {

        if (html == null) {
            return new Elements();
        } else {
            return html.select(type + "[src]");
        }

    }

    /*
    each selector get one src
     */
    public static List<String> getListOneSource(Element html, String cssSelector, String type) {
        List<String> listSource = new LinkedList<>();

        if (html == null || cssSelector == null || cssSelector.isEmpty()) {
            //html null
        } else {
            html.select(cssSelector).forEach(x -> {
                listSource.add(x.select(type + "[src]").attr("src"));
            });
        }

        return listSource;
    }

    public static Elements getListOneSourceElements(Element html, String cssSelector, String type) {

        if (html == null || cssSelector == null || cssSelector.isEmpty()) {
            return new Elements();
        } else {
            return html.select(cssSelector).select(type + "[src]");

        }
    }

    /*
    get all src
     */
    public static List<String> getListAllSourceRecursive(Elements html, String type) {
        List<String> listSource = new LinkedList<>();

        if (html == null) {
            //html null
        } else {
            html.select(type + "[src]").forEach(x -> {
                listSource.add(x.attr("src"));
            });
        }

        return listSource;
    }

    public static List<String> getListAllSourceRecursive(Element html, String type) {
        return getListAllSourceRecursive(html.children(),type);
    }

    public static Elements getListAllSourceRecursiveElements(Element html, String type) {

        if (html == null) {
            return new Elements();
        } else {
            return html.select(type + "[src]");
        }
    }

    /*
    each selector get all src
     */
    public static List<String> getListAllSourceRecursive(Element html, String cssSelector, String type) {
        List<String> listSource = new LinkedList<>();

        if (html == null || cssSelector == null || cssSelector.isEmpty()) {
            //html null
        } else {
            html.select(cssSelector).select(type + "[src]").forEach(x -> {
                listSource.add(x.attr("src"));
            });
        }

        return listSource;
    }

    public static Elements getListAllSourceRecursiveElements(Element html, String cssSelector, String type) {

        Elements e = new Elements();
        if (html == null || cssSelector == null || cssSelector.isEmpty()) {

        } else {
            Elements selected = html.select(cssSelector);
            if (selected != null)
                e = selected.select(type + "[src]");
        }

        return e;
    }
//    if (url == null
//            || (include != null && !include.equals("") && !url.contains(include))
//            || (exclude != null && !exclude.equals("") && url.contains(exclude))) {
//        url = null;
//    }

}
