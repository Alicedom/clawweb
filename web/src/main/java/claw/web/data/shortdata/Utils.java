package claw.web.data.shortdata;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Utils {

    public static <T> List<T> clean(List<T> list){
        Set<T> set = new HashSet<T>(list);
        set.remove("");
        set.remove(null);

        return new LinkedList<>(set);
    }
}
