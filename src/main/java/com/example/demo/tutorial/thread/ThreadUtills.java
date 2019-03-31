package com.example.demo.tutorial.thread;



public class ThreadUtills {

    public void testWaitAndNotify() {
        Object lock = new Object();
        Thread waitThread = new Thread(() -> {
            ThreadWait threadWait = new ThreadWait(lock);
            threadWait.testWait();
        });
        Thread notifyThread = new Thread(() -> {
            ThreadNotify threadNotify = new ThreadNotify(lock);
            threadNotify.testNotify();
        });
        waitThread.start();
        /**
         * 保证waitThread一定会先开始启动
         */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyThread.start();
    }
}
