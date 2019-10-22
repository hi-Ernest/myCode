package com.leetcode.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitSignalExample {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void after() {
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main (String[] args) {
        AwaitSignalExample example = new AwaitSignalExample();

        /**
         * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
         */
        ExecutorService executorService = Executors.newCachedThreadPool();


        /**
         * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
         * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
         * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
         *
         * 1.减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。
         *
         * 2.可以根据系统的承受能力，调整线程池中工作线线程的数目，防止因为消耗过多的内存，
         * 而把服务器累趴下(每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大，最后死机)。
         */
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());

    }
}
