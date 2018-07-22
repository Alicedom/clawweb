package claw.web.data.entry;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Href {

    public static List<String> getListHrefRecursives(Element html, String cssSelector, String type, String include, String exclude){
        List<String> entryList = new LinkedList<>();

        if(html == null){

        }else{
            Elements elements;

            if(cssSelector == null || cssSelector.equals("")){
                elements = html.children();
            }else{
                elements = html.select(cssSelector);
            }
            elements.select(type+"[href]").forEach(x->{
                String url = x.attr("href");
                if(url == null
                        || (include != null && !include.equals("") && url.contains(include))
                        || (exclude != null && !exclude.equals("") && url.contains(exclude))){

                }else{
                    entryList.add(url);
                }
            });
        }
        return entryList;
    }

    public static Map<String, String> getMapHrefRecursives(Element html, String cssSelector, String type, String include, String exclude){
        Map<String, String> entryList = new TreeMap<>();

        if(html == null){

        }else{
            Elements elements;

            if(cssSelector == null || cssSelector.equals("")){
                elements = html.children();
            }else{
                elements = html.select(cssSelector);
            }
            elements.select(type+"[href]").forEach(x->{
                String url = x.attr("href");
                if(url == null
                        || (include != null && !include.equals("") && url.contains(include))
                        || (exclude != null && !exclude.equals("") && url.contains(exclude))){

                }else{
                    entryList.put(url, x.text());
                }
            });
        }
        return entryList;
    }
}
