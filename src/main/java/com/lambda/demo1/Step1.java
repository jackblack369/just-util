package com.lambda.demo1;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Step1 {

    @Test
    public void test() {
        List<String> a = Arrays.asList("a","b","c");
        System.out.println(a);
        List<String> b = a.stream().filter(e->e.equals("a")).collect(Collectors.toList());
        System.out.println(b);
    }

    @Test
    public void test5() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection
                .stream()
//                .map(String::toUpperCase)
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        OpeType opeType = OpeType.DELETE;
        System.out.println(opeType.equals(OpeType.DELETE));
    }
}
enum OpeType{
    DELETE,
    INSERT,
}

class PersonInfo {
    @JsonProperty(value = "所属机构")
    String orgNo;
    @JsonProperty(value = "姓名")
    String empeName;
    @JsonProperty(value = "工号")
    String empeNo;
    @JsonProperty(value = "手机号码")
    String mobileNo;

    private Map<String,Object> convertToMap(){
        return null;
    }
}
