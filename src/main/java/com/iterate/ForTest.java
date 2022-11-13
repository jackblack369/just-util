package com.iterate;

import org.junit.Test;

public class ForTest {

    @Test
    public void test1() throws Exception{
        for(;;){
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis());
        }
    }
}
