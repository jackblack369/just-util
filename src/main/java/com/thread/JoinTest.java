package com.thread;

import org.junit.Test;

public class JoinTest {

    private static int[] arr = new int[10];
    public static void main(String[] args) {
        System.out.println(arr[2]);
    }

    @Test
    public void test1() {
        Thread threadA = new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println("threadA:"+i);
            }
        });

        Thread threadB = new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println("threadB:"+i);
            }
        });

        threadA.start();

        try {
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }
}
