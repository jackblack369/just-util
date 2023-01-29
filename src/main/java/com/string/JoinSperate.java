package com.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JoinSperate {

    List<String> sourceCols = Arrays.asList("dong","wei");


    @Test
    public void test1(){

        String sourceCol = StringUtils.join(sourceCols," ");
        System.out.println(sourceCol);
        System.out.println(sourceCol.length());
    }

    @Test
    public void test2(){
        Map<String, String> in = new HashMap<>();
        in.put("dong", "1");
        in.put("wei","2");
        List<String> valList = sourceCols.stream()
                .map(col->in.get(col).toString())
                .collect(Collectors.toList());
        System.out.println(valList);
    }

}
