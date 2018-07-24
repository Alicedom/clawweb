package claw.web.data.shortdata;

import java.util.*;

public class Utils {

    public static <T> List<T> clean(List<T> list){
        Set<T> set = new HashSet<T>(list);

        set.remove("");
        set.remove(null);

        return new LinkedList<>(set);
    }

    public static <K,V> Map<K,V> clean(Map<K,V> map){

        map.remove("");
        map.remove(null);

        return map;
    }

    public static <K,V> Map<K,V> convertMap(K k, List<V> list){
        Map<K,V> map = new HashMap<>();

        list.forEach(x->{
            map.put(k,x);
        });

        return map;
    }

    public static String cleanURL(String url){
        return url.replace(" ","%20");
    }
}
