package com.thread;

public class ThreadDemo {

    static Thread testThread1 = new Thread(new Thread1("dongwei"));
    static Thread testThread2 = new Thread(new Thread1("shirley"));

    public static void main(String[] args) {
        testThread1.start();
        testThread2.start();
    }
}


class Thread1 implements Runnable {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private String a;
    public Thread1(String a) {
        this.a = a;
    }

    @Override
    public void run() {
        threadLocal.set(a);
        System.out.println("hello, "+threadLocal.get());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello wait, "+threadLocal.get());
    }
}