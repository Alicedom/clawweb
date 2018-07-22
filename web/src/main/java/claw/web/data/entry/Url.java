package claw.web.data.entry;

import java.util.LinkedList;
import java.util.List;

public class Url {

    public static List<String> getListHttp(String html) {
        return getListAttrStartWith(html,"http://");
    }

    public static List<String> getListHttps(String html) {

        return getListAttrStartWith(html,"https://");
    }

    public static List<String> getListAttrStartWith(String html, String attr) {
        List urlList = new LinkedList();
        String[] list = html.split(attr);
        if (list.length >= 1) {
            for (int i = 1; i < list.length; i++) {

                String url = list[i].substring(0, list[i].indexOf("\"")).substring(0, list[i].indexOf("\'"));
                if(url == null || url.equals("")){

                }else{
                    urlList.add(attr + url);
                }
            }
        }

        return urlList;
    }

}
