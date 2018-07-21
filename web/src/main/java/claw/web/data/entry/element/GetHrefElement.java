package claw.web.data.entry.element;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GetHrefElement {

    /*
    get all link in
    @selector: select html smaller to get href. selector can be null
    @type: img, video, audio... or null
    @include: accept condition. include can be null
    @exclude: reject condition. exclude can be null
     */
    public static List<String> getListHrefRecursives(Element html, String cssSelector, String type, String include, String exclude) {
        if (html == null) {
            return new LinkedList<>();
        } else {
            return getListHrefRecursives(html.children(), cssSelector, type, include, exclude);
        }

    }

    public static List<String> getListHrefRecursives(Elements html, String cssSelector, String type, String include, String exclude) {
        List<String> listHrefLink = new LinkedList<>();

        if (html == null) {
            //html null
        } else {
            if (cssSelector == null || cssSelector.isEmpty()) {
                //css null
            } else {
                html = html.select(cssSelector);
            }

            html.select(type + "[href]").forEach(y -> {
                String url = y.attr("abs:href");
                if (url == null
                        || (include != null && !include.equals("") && !url.contains(include))
                        || (exclude != null && !exclude.equals("") && url.contains(exclude))) {
                    //reject
                } else {
                    listHrefLink.add(url);
                }
            });
        }
        return listHrefLink;
    }

    public static Map<String, String> getMapHrefRecursives(Element html, String cssSelector, String type, String include, String exclude) {
        if (html == null) {
            return new TreeMap<>();
        } else {
            return getMapHrefRecursives(html.children(), cssSelector, type, include, exclude);
        }
    }

    public static Map<String, String> getMapHrefRecursives(Elements html, String cssSelector, String type, String include, String exclude) {
        Map<String, String> listHrefLink = new TreeMap<>();

        if (html == null) {
            //html null
        } else {
            if (cssSelector == null || cssSelector.isEmpty()) {
                //css null
            } else {
                html = html.select(cssSelector);
            }

            html.select(type + "[href]").forEach(y -> {
                String url = y.attr("abs:href");
                if (url == null
                        || (include != null && !include.equals("") && !url.contains(include))
                        || (exclude != null && !exclude.equals("") && url.contains(exclude))) {
                    //reject
                } else {
                    listHrefLink.put(url, y.text());
                }
            });
        }

        return listHrefLink;
    }


}
