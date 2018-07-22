package claw.web.data.shortdata;

import claw.web.data.entry.Href;
import claw.web.data.fulldata.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;
/*
get entry and short html on category
 */
public class DataCategory {
    private Element html;
    private int minAccept, maxAccept;

    public DataCategory(Element document) {
        this.html = document;
    }

    public DataCategory(String html, int minAccept, int maxAccept){
        this.html = Jsoup.parse(html);
        this.maxAccept = maxAccept;
        this.minAccept = minAccept;

    }

    public DataCategory(Element html, int minAccept, int maxAccept){
        this.html = html;
        this.minAccept = minAccept;
        this.maxAccept = maxAccept;

    }

    /*
    @cssSelector: parse html to take list element that have url and some information of each article
    @cssSelectorSmaller: select smaller element to extract url. If you have no rule, set null or ""
    @include: str rule to choice url. If you have no rule, set null or ""
    @exclude: str rule to reject url. If you have no rule, set null or ""
     */
    public List<Article> getEntriesOnCategory(String cssSelector, String cssSelectorSmaller, String include, String exclude) {
        List<Article> dataArticleList = new LinkedList<>();

        if(cssSelector == null || cssSelector.equals("")){

        }else{
            for (Element x : html.select(cssSelector)) {
                List<String> url = Href.getListHrefRecursives(x, "a", cssSelectorSmaller, include, exclude);

                if (url == null || url.size() == 0) {

                } else {
                    Article data = new Article(url.get(0));
                    data.setElement(x);
                    dataArticleList.add(data);
                }
            }

            if((minAccept > 0 && minAccept > dataArticleList.size())
                    || (maxAccept > 0 && maxAccept < dataArticleList.size())){
                dataArticleList = new LinkedList<>();
            }
        }

        return dataArticleList;
    }

    public  List<String> getEntriesOnCategory(String cssSelector, String include, String exclude){
        return Href.getListHrefRecursives(html,cssSelector,"a",include,exclude);
    }

    public Elements getElementsOnCategory(String cssSelector){

        if(cssSelector == null || cssSelector.equals("")){

            return new Elements();
        }else{
            return  html.select(cssSelector);
        }
    }
}
