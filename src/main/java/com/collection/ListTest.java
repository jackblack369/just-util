package com.collection;

import org.junit.Test;

import java.util.ArrayList;

public class ListTest {

    @Test
    public void test1() {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        l1.add(3);
        l1.add(5);
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        l2.add(2);
        l2.add(4);
        l2.add(6);

        l1.addAll(l2);
        System.out.println(l1);

    }

}
