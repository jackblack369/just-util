package com.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

    @Test
    public void testOne(){
        Set<TYPE> typeSet = new HashSet<TYPE>(Arrays.asList(TYPE.SMALL,TYPE.MIDDLE,TYPE.BIG));
        typeSet.removeIf(e -> e.equals(TYPE.BIG));
        System.out.println(typeSet);
    }

    enum TYPE{
        SMALL,
        MIDDLE,
        BIG
    }
}
