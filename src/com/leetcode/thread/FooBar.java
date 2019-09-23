package com.leetcode.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class FooBar {

    private int n;
    private CountDownLatch countDownLatch;
    private CyclicBarrier cyclicBarrier;

    public FooBar(int n) {
        this.n = n;
        countDownLatch = new CountDownLatch(1);
        cyclicBarrier = new CyclicBarrier(2); //保证每组任务能按组执行
    }

    public void foo(Runnable runnable) throws InterruptedException {
        try {
            for (int i=0; i<n; i++) {
                runnable.run();
                countDownLatch.countDown(); //printFoo方法完成调用countDown
                cyclicBarrier.await();//等待printBar方法执行结束
            }
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void bar(Runnable runnable) throws InterruptedException {
        for (int i=0; i<n; i++) {
            countDownLatch.wait();//等待printFoo方法执行
            runnable.run();
            countDownLatch = new CountDownLatch(1);
            cyclicBarrier.wait();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);
        Runnable runnable = null;
    }

    
}
