package com.generalize;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) throws Exception{
        test2();

    }

    private static void test1() {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);

        System.out.println(list1.getClass() == list2.getClass()); // true
        System.out.println(list1.getClass());
    }

    /**
     * 如果直接调用add()方法，那么只能存储整数数据，不过当我们利用反射调用add()方法的时候，却可以存储字符串，
     * 这说明了Integer泛型实例在编译之后被擦除掉了，只保留了原始类型。
     *
     * @throws Exception
     */
    private static void test2() throws Exception{

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer

        list.getClass().getMethod("add", Object.class).invoke(list, "asd");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void test3() {
//        List<String>[] list11 = new ArrayList<String>[10]; //编译错误，非法创建
//        List<String>[] list12 = new ArrayList<?>[10]; //编译错误，需要强转类型
        List<String>[] list13 = (List<String>[]) new ArrayList<?>[10]; //OK，但是会有警告
//        List<?>[] list14 = new ArrayList<String>[10]; //编译错误，非法创建
        List<?>[] list15 = new ArrayList<?>[10]; //OK
        List<String>[] list6 = new ArrayList[10]; //OK，但是会有警告

    }

}
