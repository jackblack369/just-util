package com.collection;

import org.junit.Test;

public class ArrayTest {

    @Test
    public void test1() {
        String a = "1,2,3,4, ";
        String[] A = a.split(",");
        System.out.println(A.length);
    }
}
