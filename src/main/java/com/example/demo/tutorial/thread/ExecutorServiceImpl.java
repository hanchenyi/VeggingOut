package com.example.demo.tutorial.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceImpl {
    public void test() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit( () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName);
        });
    }
}
