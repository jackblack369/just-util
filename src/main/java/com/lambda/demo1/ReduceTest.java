package com.lambda.demo1;

import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {

    @Test
    public void test1(){
        Info info1 = Info.builder().name("a").value(1).build();
        Info info2 = Info.builder().name("b").value(2).build();
        List<Info> infoList = Arrays.asList(info1, info2);
        Info result = Info.builder().name("result").build();
        System.out.println(infoList.stream().reduce(result, Info::mergeInfo));

    }


}

@Data
@Builder
class Info{
    String name;
    int value;

    public Info mergeInfo(Info info){
        this.value = this.value + info.getValue();
        return this;
    }
}
