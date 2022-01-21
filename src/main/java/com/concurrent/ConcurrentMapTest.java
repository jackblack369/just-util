package com.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConcurrentMapTest {

    public static void main(String[] args) {
        HashMap<String, ArrayList> map = new HashMap<>();
        ArrayList test = new ArrayList();
        test.add("hardwork");
        test.add("dedication");
        map.put("1", test);
//        map.compute("3", (k,v) -> v.(2) );
        //key不管存在不在都会执行后面的函数，并保存到map中
//        map.compute("4", (k,v) -> {
//            if (v==null)return 0;
//            return v+1;
//        } );
//        List<String> integers = new ArrayList<>(map.get("1"));
//        integers.add("11");

        map.get("1").add("11");
        System.out.println(map.toString());

    }
}

