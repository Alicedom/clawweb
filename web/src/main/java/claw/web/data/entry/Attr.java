package claw.web.data.entry;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;

public class Attr {

    public static String getFirstHref(Element html, String css, String attr) {
        if (html == null) {
            return null;
        } else {
            return html.select(css).select("[" + attr + "]").attr(attr);
        }
    }

    public static Elements getFirstHrefElements(Element html, String css, String attr) {
        if (html == null) {
            return new Elements();
        } else {
            return html.select(css+"["+attr+"]");
        }
    }


    public static List<String> getListHrefRecursive(Element html, String cssSelector, String css, String attr){
        List<String> urlList = new LinkedList();
        if(html == null){

        }else{
            getListHrefElements(html,cssSelector,css,attr).forEach(x->
                    urlList.add(x.attr(attr))
            );

        }

        return urlList;
    }

    public static Elements getListHrefElements(Element html, String cssSelector, String css, String attr){
        if(html == null){
            return new Elements();
        }else{
            Elements elements;
            if(cssSelector == null || cssSelector.equals("")){
                elements = html.children();
            }else{
                elements = html.select(cssSelector);
            }

            return elements.select(css+"["+attr+"]");

        }
    }

}
