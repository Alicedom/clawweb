package claw.web.data.entry;

import claw.web.data.shortdata.Utils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Href {
    private final static Logger logger = LoggerFactory.getLogger(Href.class);

    public static List<String> getListHrefRecursives(Element html, String cssSelector, String type, String include, String exclude) {
        List<String> entryList = new LinkedList<>();

        if (html == null) {
            logger.info("html null");

        } else {
            Elements elements;

            if (cssSelector == null || cssSelector.equals("")) {
                elements = html.children();
            } else {
                elements = html.select(cssSelector);
            }
            logger.info("element size: " + elements.size());
            elements.select(type + "[href]").forEach(x -> {
                String url = x.attr("abs:href");
                if (url == null
                        || (include != null && !include.equals("") && !url.contains(include))
                        || (exclude != null && !exclude.equals("") && url.contains(exclude))) {

                    logger.info("href get null: " + x.toString());
                } else {
//                    logger.info("url: "+url);
                    entryList.add(url);
                }
            });
        }
//        logger.info("href size: "+entryList.size());
        return Utils.clean(entryList);
    }

    public static List<String> getListHrefRecursives(Element html, String cssSelector, String type, List<String> include, List<String> exclude) {
        List<String> entryList = new LinkedList<>();

        if (html == null) {
            logger.info("html null");

        } else {
            Elements elements;

            if (cssSelector == null || cssSelector.equals("")) {
                elements = html.children();
            } else {
                elements = html.select(cssSelector);
            }
            logger.info("element size: " + elements.size());
            for (Element x : elements.select(type + "[href]")) {
                String url = x.attr("abs:href");
                if (url == null) {
                    logger.info("href get null: " + x.toString());
                } else {
                    boolean chooseURL = true;
                    if (exclude == null) {

                    } else {
                        for (String s : exclude) {
                            if (url.contains(s)) {
                                chooseURL = false;
                                break;
                            }

                        }
                    }

                    if (chooseURL == true) {
                        if (include == null) {
                            if (chooseURL == true)
                                entryList.add(url);

                        } else {
                            for (String s : exclude) {
                                if (url.contains(s)) {
                                    entryList.add(url);
                                    break;
                                }

                            }
                        }

                    }
                }
            }
        }
//        logger.info("href size: "+entryList.size());
        return Utils.clean(entryList);
    }

    public static Map<String, String> getMapHrefRecursives(Element html, String cssSelector, String type, String include, String exclude) {
        Map<String, String> entryList = new TreeMap<>();

        if (html == null) {

        } else {
            Elements elements;

            if (cssSelector == null || cssSelector.equals("")) {
                elements = html.children();
            } else {
                elements = html.select(cssSelector);
            }
            elements.select(type + "[href]").forEach(x -> {
                String url = x.attr("href");
                if (url == null
                        || (include != null && !include.equals("") && !url.contains(include))
                        || (exclude != null && !exclude.equals("") && url.contains(exclude))) {

                } else {
                    entryList.put(url, x.text());
                }
            });
        }
        return Utils.clean(entryList);
    }

    public static Map<String, String> getMapHrefRecursives(Elements html, String cssSelector, String type, String include, String exclude) {
        Map<String, String> entryList = new TreeMap<>();

        if (html == null) {

        } else {
            Elements elements;

            if (cssSelector == null || cssSelector.equals("")) {
                elements = html;
            } else {
                elements = html.select(cssSelector);
            }
            elements.select(type + "[href]").forEach(x -> {
                String url = x.attr("href");
                if (url == null
                        || (include != null && !include.equals("") && !url.contains(include))
                        || (exclude != null && !exclude.equals("") && url.contains(exclude))) {

                } else {
                    entryList.put(url, x.text());
                }
            });
        }
        return Utils.clean(entryList);
    }

    public static Map<String, String> getMapHrefRecursives(Elements html, String cssSelector) {
        Map<String, String> entryList = new TreeMap<>();

        if (html == null) {

        } else {
            Elements elements;

            if (cssSelector == null || cssSelector.equals("")) {
                elements = html;
            } else {
                elements = html.select(cssSelector);
            }
            elements.select("[href]").forEach(x -> {
                String url = x.attr("href");
                if (url == null) {

                } else {
                    entryList.put(url, x.text());
                }
            });
        }

        return Utils.clean(entryList);
    }

}
