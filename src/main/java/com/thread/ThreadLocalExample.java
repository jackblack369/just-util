package com.thread;

public class ThreadLocalExample {
    public static void main(String[] args) throws Exception {
        ThreadLocal threadLocal1 = new ThreadLocal();
        ThreadLocal threadLocal2 = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal1.set(1);
            threadLocal2.set(1);
            System.out.println("thread1 local1: "+threadLocal1.get());
            System.out.println("thread1 local2: "+threadLocal2.get());
        });
        Thread thread2 = new Thread(() -> {
            threadLocal1.set(2);
            threadLocal2.set(2);
            System.out.println("thread2 local1: "+threadLocal1.get());
            System.out.println("thread2 local2: "+threadLocal2.get());
        });
        thread1.start();
        thread2.start();
    }
}

