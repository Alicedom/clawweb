package claw.web.test;

import java.util.*;

public class TestDuplicateKeyMap {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();

    }

    public static void test1(){
        Map<String, Integer> tm=new TreeMap<>();
        tm.put("vivek", 1);
        tm.put("vivek", 2);
        System.out.println(tm);
    }

    public static void test2(){
        Map<String, Integer> tm=new HashMap<>();
        tm.put("vivek", 1);
        tm.put("vivek", 2);
        System.out.println(tm);
    }

    public static void test3(){
        Map<String, Integer> tm=new WeakHashMap<>();
        tm.put("vivek", 1);
        tm.put("vivek", 2);
        System.out.println(tm);
    }

    public static void test4(){
        Map<String, Integer> tm=new Hashtable<>();
        tm.put("vivek", 1);
        tm.put("vivek", 2);
        System.out.println(tm);
    }

    public static void test5(){
        Map<String, Integer> tm=new IdentityHashMap<>();
        tm.put("vivek", 1);
        tm.put("vivek", 2);
        System.out.println(tm);
    }

    public static void test6(){
        Map<String, Integer> tm=new LinkedHashMap<>();
        tm.put("vivek", 1);
        tm.put("vivek", 2);
        System.out.println(tm);
    }
}
