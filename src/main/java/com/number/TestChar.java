package com.number;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestChar {

    @Test
    public void test1() {
        String info = "06";

        long start = System.nanoTime();
        System.out.println(StringUtils.isNumeric(info));
        long end1 = System.nanoTime();
        System.out.println("StringUtils cost:"+ (end1-start));

        System.out.println(isNumeric(info));
        long end2 = System.nanoTime();
        System.out.println("pattern cost:"+ (end2-end1));

        System.out.println(isNumeric2(info));
        long end3 = System.nanoTime();
        System.out.println("pattern cost:"+ (end3-end2));

        System.out.println(isNumeric3(info));
        long end4 = System.nanoTime();
        System.out.println("pattern cost:"+ (end4-end3));



    }

    public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    public boolean isNumeric2(String str){
        if ( !str.matches("\\d+")) {
            return false;
        }
        return true;
    }

    public boolean isNumeric3(String str) {
        if (!Character.isDigit(str.charAt(0))){
            return false;
        }
        return true;
    }

    @Test
    public void test3() {
        Integer a = 10;
        System.out.println(a.toString());
    }

    @Test
    public void test4() {
        Map<Integer, Integer> parentChannels = new HashMap<>();
        parentChannels.put(1,100);
        parentChannels.put(2,200);
        int CHNL_CNT = 300;
        for(int i=1;i<3;i++){
            parentChannels.compute(i, (key, oldValue) -> oldValue == null ? CHNL_CNT : (oldValue + CHNL_CNT));
        }
        System.out.println(parentChannels);
    }
}
