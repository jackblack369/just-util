package com.string;

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
}
