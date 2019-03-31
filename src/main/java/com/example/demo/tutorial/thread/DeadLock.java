package com.example.demo.tutorial.thread;

public class DeadLock {
    private static boolean flag = false;
    static {
        Runnable a = () -> flag = true;
        Thread t = new Thread(a);
        t.start();
        System.out.println("t.currentThread().getName() is " + t.currentThread().getName());
        try {
            System.out.println("invoking join");
            System.out.println("t.currentThread().getName() is " + t.currentThread().getName());
            t.join();
            System.out.println("exiting join");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
