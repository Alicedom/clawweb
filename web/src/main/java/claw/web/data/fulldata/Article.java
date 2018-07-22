package claw.web.data.fulldata;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class Article {
    private String url; //url from short html
    private Element element; // short html from category
    private Map<String, String> textMap; // title, sapo, date, author, tag. category???
    private List<String> srcList; // url src. feature image is first img in list
    private Map<String,String> hrefMap; // href in tagname/ text referance
    private Elements body; //body content

    public Article(String url) {
        this.url = url;
        textMap = new TreeMap<>();
        srcList = new LinkedList<>();
        body = new Elements();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Map<String, String> getTextMap() {
        return textMap;
    }

    public void setTextMap(Map<String, String> textMap) {
        this.textMap = textMap;
    }

    public List<String> getSrcList() {
        return srcList;
    }

    public void setSrcList(List<String> srcList) {
        this.srcList = srcList;
    }

    public Elements getHtmlList() {
        return body;
    }

    public void setHtmlList(Elements body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "DataArticle{" +
                "url='" + url + '\'' +
                ", textMap=" + textMap +
                ", element=" + element +
                ", body=" + body +
                ", srcList=" + srcList +
                ", hrefMap=" + hrefMap +
                '}';
    }
}
