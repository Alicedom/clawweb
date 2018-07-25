package claw.web.data.fulldata;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class Body {
    public static Elements getBody(Element element, List<String> cssSelectorContent, String cssRemoveContent, String preURL, String replace){

        if(cssRemoveContent == null || cssRemoveContent == ""){

        }else{
            element.select(cssRemoveContent).remove();
        }

        Elements body = new Elements();
        cssSelectorContent.forEach(x->body.addAll(element.select(x)));

        return body;
    }
}
