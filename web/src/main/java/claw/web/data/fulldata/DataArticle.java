package claw.web.data.fulldata;

import claw.web.data.entry.Href;
import claw.web.data.entry.Src;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.Map;

/*
get full data
 */
public class DataArticle {
    Article article;

    public DataArticle(String url) {
        article = new Article(url);
    }

    public DataArticle(Article article) {
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }

    /*
        get text from element
    */
    public Map<String, String> setText(Element e, Map<String, String> cssQueryText) {
        Map<String, String> mapText = article.getTextMap();
        if (e == null || !e.hasText()) {

        } else {
            cssQueryText.forEach((k, v) -> {
                String text = e.select(v).text();

                if (text == null || text.isEmpty()) {

                } else if (!mapText.containsKey(k)) {
                    mapText.put(k, text);
                } else if (mapText.get(k) == null || mapText.get(k).equals("")) {
                    mapText.replace(k, text);
                }
            });

        }

        return mapText;
    }

    public Elements setBody(Element element, List<String> cssSelectorContent, String cssRemoveContent, String preURL, String replace){

        if(cssRemoveContent == null || cssRemoveContent == ""){

        }else{
            element.select(cssRemoveContent).remove();
        }

        Elements body = new Elements();
        cssSelectorContent.forEach(x->body.addAll(element.select(x)));

        article.setBody(body.toString().replace(preURL,replace));
        return body;
    }

    public List<String> setSrc(Elements content){
        List<String> list =  Src.getListAllSourceRecursive(content,"","");
        article.setSrcList(list);
        return list;

    }

    public List<String> setSrc(Element content){
        List<String> list =  Src.getListAllSourceRecursive(content,"","");
        article.setSrcList(list);
        return list;

    }

    public Map<String, String> setHref(Element content, String include, String exclude){
        Map<String, String> map = Href.getMapHrefRecursives(content,"","a",include,exclude);
        article.setHrefMap(map);
        return map;
    }

    public Map<String, String> setHref(Elements content, String include, String exclude){
        Map<String, String> map = Href.getMapHrefRecursives(content,"","a",include,exclude);
        article.setTextMap(map);
        return map;
    }

    /*
    get data body & src in body selected
     */
    public void getParseDataFromLink(Document document, List<String> cssSelectorContent, String cssRemoveContent) {
        Elements content = new Elements();
        List<String> listSrc = article.getSrcList();

        if (cssRemoveContent == null || cssRemoveContent.isEmpty()) {
            //pass css remove
        } else {
            document.select(cssRemoveContent).remove();
        }

        if (cssSelectorContent == null || cssSelectorContent.size() == 0) {

        } else {
            for (String contentClass : cssSelectorContent) {
                Elements elements = document.select(contentClass);

                listSrc.addAll(Src.getListAllSourceRecursive(elements, "",""));
                content.addAll(elements);
            }
        }

        article.setBody(content.toString());
        article.setSrcList(listSrc);
    }
}
