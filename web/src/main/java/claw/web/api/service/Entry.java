package claw.web.api.service;

import claw.web.data.connect.Html;
import claw.web.data.fulldata.Article;
import claw.web.data.fulldata.DataArticle;
import claw.web.data.shortdata.DataCategory;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Entry {
    private DataCategory dataCategory;

    private List<Article> articleList;

    private List<String> entryList;

    public Document connect(String url, String userAgent, HashMap cookies, int timeout, String method){
        Document document = Html.getDocument(url,userAgent,cookies,timeout,method);
        dataCategory = new DataCategory(document);
        return document;
    }

    public List<String> getEntry(String cssSelector, String include, String exclude){
        entryList =  dataCategory.getEntriesOnCategory(cssSelector, include, exclude);
        return entryList;
    }

    public List<Article> getShortData(String cssSelector, String cssSmaller, String include, String exclude){
        articleList =  dataCategory.getArticlesOnCategory(cssSelector, cssSmaller,include, exclude);
        return articleList;
    }


    public List<Article> setBody( List<String> cssSelectorContent, String cssRemoveContent, Map cssQueryText, String include, String exclude, String preURL, String replace){
        articleList.forEach(x->{
            Document document = Html.getDocument(x.getUrl(),"",null,0,null);

            DataArticle dataArticle =  new DataArticle(x);
            dataArticle.setText(document, cssQueryText);
            Elements body = dataArticle.setBody(document,cssSelectorContent,cssRemoveContent, preURL, replace);

            dataArticle.setSrc(body);
            dataArticle.setHref(body, include, exclude);

            x = dataArticle.getArticle();

        });

        return articleList;
    }

}
