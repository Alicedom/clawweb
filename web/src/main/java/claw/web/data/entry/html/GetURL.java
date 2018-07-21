package claw.web.data.entry.html;

import java.util.LinkedList;
import java.util.List;
/*
get every attr in HTML
 */
public class GetURL {
    public static List<String> getListAttrStartWith(String html, String attr) {
        List<String> httpList = new LinkedList<>();

        if (html == null || html.isEmpty() || attr == null || attr.isEmpty()) {

        } else {
            String[] data = html.split(attr);

            if (data == null || data.length == 0) {
            } else {
                for (int i = 1; i < data.length; i++) {
                    String attText = attr + data[i].split("\"")[0].split("\'")[0];
                    httpList.add(attText);
                }
            }
        }
        return httpList;
    }

    public static List<String> getListHttp(String html) {
        return getListAttrStartWith(html, "http://");
    }

    public static List<String> getListHttps(String html) {
        return getListAttrStartWith(html, "https://");
    }
}
