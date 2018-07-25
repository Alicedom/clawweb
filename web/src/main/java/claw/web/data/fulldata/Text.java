package claw.web.data.fulldata;

import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Map;

public class Text {

    public Map<String, String> getText(Element e, Map<String, String> cssQueryText) {
        Map<String, String> mapText = new HashMap<>();

        if (e == null || !e.hasText()) {

        } else {
            cssQueryText.forEach((k, v) -> {
                String text = e.select(v).text();

                if (text == null || text.isEmpty()) {

                } else if (mapText.get(k) == null || mapText.get(k).equals("")) {
                    mapText.replace(k, text);
                }
            });
        }

        return mapText;
    }

    public Map<String, String> setText(Element e, Map<String, String> cssQueryText, Map<String, String> replaceMap) {
        Map<String, String> mapText = new HashMap<>();

        if (e == null || !e.hasText()) {

        } else {
            cssQueryText.forEach((k, v) -> {
                String text = e.select(v).text();



                if (text == null || text.isEmpty()) {

                } else  {
                    for(Map.Entry<String, String> entry : replaceMap.entrySet()){
                        if(text.contains(entry.getKey())){
                            text = text.replace(entry.getKey(),entry.getValue());
                        }
                    }
                }
            });
        }

        return mapText;
    }

}
