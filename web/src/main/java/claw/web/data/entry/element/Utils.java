package claw.web.data.entry.element;

import java.util.*;

public class Utils {
    public static List<String> removeDuplicate(List list){
        Set<String> set = new LinkedHashSet<String>(list);
        set.remove(null);
        set.remove("");

        return new LinkedList<>(set);
    }

}
