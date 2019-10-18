package com.example.demo.tutorial.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceImpl {
    public void test() {
        List<Integer> secondRange = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> {
            secondRange.parallelStream().forEach(num -> {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName);
            });
        });
    }
}
