package claw.web.data.shortdata;

import java.io.File;
import java.io.IOException;
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

    public static <K,V> Map<K,V> convert(K k, List<V> list){
        Map<K,V> map = new HashMap<>();

        if(k != null){
            list.forEach(x->{
                map.put(k,x);
            });
        }

        return map;
    }

    public static <K,V> List<V> convert(Map<K,V> map){
        List<V> list = new LinkedList<>();

        map.forEach((k,v)->{
           if (v != null){
               list.add(v);
           }
        });

        return list;
    }

    private static void checkAndCreateNewFile(String file) {
        File log = new File(file);

        if (!log.exists()) {
            try {

                log.getParentFile().mkdirs();
                log.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
