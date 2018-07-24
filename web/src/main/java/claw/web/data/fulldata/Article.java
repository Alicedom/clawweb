package claw.web.data.fulldata;


import java.util.*;

public class Article {
    private String url; //url from short html
    private Map<String, String> textMap; // title, sapo, date, author, tag. category???
    private String element; // short html from category
    private String body; //body content
    private List<String> srcList; // url src. feature image is first img in list
    private Map<String,String> hrefMap; // href in tagname/ text referance


    public Article(String url) {
        this.url = url;
        textMap = new TreeMap<>();
        srcList = new LinkedList<>();
        body = "";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHrefMap() {
        return hrefMap;
    }

    public void setHrefMap(Map<String, String> hrefMap) {
        this.hrefMap = hrefMap;
    }

    @Override
    public String toString() {
        return "Article{" +
                "url='" + url + '\'' +
                ", textMap=" + textMap +
                ", element='" + element + '\'' +
                ", body='" + body + '\'' +
                ", srcList=" + srcList +
                ", hrefMap=" + hrefMap +
                '}';
    }
}
