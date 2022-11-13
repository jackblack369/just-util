package com.lambda.demo1;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Step2 {

    @Test
    public void test1() {
        ArrayList<Cust> custInfos = new ArrayList<>();
        Cust cust1 = Cust.builder().acct("1").type("in").amt("1000").build();
        Cust cust2 = Cust.builder().acct("2").type("out").amt("2000").build();
        Cust cust3 = Cust.builder().acct("3").type("in").amt("3000").build();
        custInfos.add(cust1);
        custInfos.add(cust2);
        custInfos.add(cust3);

        ArrayList<Cust> others = new ArrayList<>();
        Cust cust4 = Cust.builder().acct("1").type("in").amt("1000").build();
        Cust cust5 = Cust.builder().acct("5").type("in").amt("1000").build();
        Cust cust6 = Cust.builder().acct("6").type("out").amt("2000").build();
        others.add(cust4);
        others.add(cust5);
        others.add(cust6);

        custInfos.forEach(
                newItem -> {
                    others.removeIf(record ->{
                        if(record.same(newItem)){
                            return true;
                        };
                        return false;
                    });
                });

        others.stream().forEach(System.out::println);
    }


}
@Getter
@Setter
@Builder
@ToString
class Cust{
    String acct;
    String type;
    String amt;

    public boolean same(Cust other){
        return this.acct == other.acct && this.type == other.type;
    }
}