package com.string;

import org.junit.Test;

import java.util.HashMap;

public class MultiplyParam {

    public static void main(String[] args) {
        test(1,"a");
        test(2,"a", "b");
    }

    public static void test(int a, String... content){
        if (content.length == 1) {
            System.out.println("1");
        } else if (content.length == 2) {
            System.out.println("2");
        }
    }

    @Test
    public void test1(){
        HashMap rowMap = new HashMap();
        rowMap.put("CREATE_DATE", "20221016");
        rowMap.put("CREATE_TIME", "192510");
        String content = "CREATE_DATE || CREATE_TIME";
        String dateTime = "";
        for (String col : content.split("\\|\\|")) {
            dateTime += String.valueOf(rowMap.get(col.trim()));
        }
        System.out.println(dateTime);
    }
}
