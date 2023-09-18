package com.lambda.foreachremain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Test1 {

    @Test
    public void test1() {
        List<String> info = Arrays.asList("dong", "wei", "ren");
        StringJoiner stringJoiner = new StringJoiner(":");
        info.iterator().forEachRemaining(e->{
//            if(e.equals("dong")){
//                return;
//            }
            stringJoiner.add(e);
        });
        System.out.println(stringJoiner.toString());

    }

    @Test
    public void test3(){
        List<String> info = Arrays.asList("dong", "wei", "ren");
        info.parallelStream().forEach(e-> {
            if (e.equals("dong")) {
                return;
            }
            System.out.println(e);
        });
    }

    @Test
    public void test2() {
        String[] channels = {"1","24"};
        System.out.println(Arrays.stream(channels).anyMatch(channel -> channel.equals("24")));
    }
}
