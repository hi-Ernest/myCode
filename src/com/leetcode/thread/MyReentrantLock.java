package com.leetcode.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock {

    private Lock lock = new ReentrantLock();

    public void fun() {
        lock.lock();
        try {
            for (int i=0; i<10; i++) {
                System.out.println(i+ " ");
            }

        } finally {
            lock.unlock(); //确保释放锁,防止死锁
        }
    }


    public static void main(String[] args) {
        MyReentrantLock example = new MyReentrantLock();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> example.fun());
        executorService.execute(() -> example.fun());
    }
}
