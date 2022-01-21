package com.jackson;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastJsonTest {


    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception{
        Map<String, String> map = new HashMap<>();
        map.put("a","aaa");
        map.put("b","bbb");
        map.put("c","ccc");

        List list = new ArrayList();
        list.add(map);
        Map<String, String> map2 = new HashMap<>();
        map2.put("a2","aaa");
        map2.put("b2","bbb");
        map2.put("c2","ccc");
        list.add(map2);

//        String mapStr = JSON.toJSON(map).toString();

        String listMapStr = objectMapper.writeValueAsString(list);

        try {
            List result = objectMapper.readValue(listMapStr, List.class);
            System.out.println(listMapStr);
            System.out.println(result);
//            System.out.println(result.get("d"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
