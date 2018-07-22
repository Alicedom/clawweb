package claw.web.data.entry;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;

public class Src {

    public static String getFirstSource(Element html, String type){
        if(html == null){
            return null;
        }else{
            return html.select(type+"[src]").attr("src");
        }
    }

    public static Elements getFirstSourceElements(Element html, String type){
       if(html == null){
           return null;
       }else{
           return html.select(type+"[src]");
       }

    }

    public static List<String> getListOneSource(Element html, String cssSelector, String type){
        List<String> listSrc = new LinkedList<>();

        if(html == null){

        }else{
            Elements elements;
            if(cssSelector == null || cssSelector.equals("")){
                elements = html.children();
            }else{
                elements = html.select(cssSelector);
            }

            elements.forEach(x->{
                String url = x.select(type+"[src]").attr("src");
                listSrc.add(url);
            });
        }

        return listSrc;

    }

    public static Elements getListOneSourceElements(Element html, String cssSelector, String type){

        return html.select(cssSelector).select(type+"[src]");
    }

    public static List<String> getListAllSourceRecursive(Element html, String cssSelector, String type){
        return getListAllSourceRecursive(html.children(),cssSelector,type);
    }

    public static List<String> getListAllSourceRecursive(Elements html, String cssSelector, String type){
        List<String> listSrc = new LinkedList<>();

        if(html == null){

        }else{
            Elements elements;
            if(cssSelector == null || cssSelector.equals("")){
                elements = html;
            }else{
                elements = html.select(cssSelector);
            }

            elements.select(type+"[src]").forEach(x->{
                String url = x.attr("src");
                listSrc.add(url);
            });
        }

        return listSrc;
    }

    public static Elements getListAllSourceRecursiveElements(Element html, String cssSelector, String type){

        if(html == null){
            return new Elements();

        }else{

            if(cssSelector == null || cssSelector.equals("")){
                return html.children();
            }else{
                return html.select(type+"[src]");
            }
        }
    }
}
