package com.leetcode.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 互斥同步
 * 1.使用Synchronized
 */
public class MySynchronized {

    /**
     * 同步代码块
     */
    public void func1() {
        synchronized (this) {
            for (int i=0; i<10; i++) {
                System.out.println(i+ " "+Thread.currentThread().getName());
            }
        }
    }


    public static void main(String[] args) {
        MySynchronized ms = new MySynchronized();
        MySynchronized ms2 = new MySynchronized();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> ms.func());
        executorService.execute(() -> ms2.func());
    }

    /**
     * 同步一个方法
     */
    public synchronized void func2() {
        //todo
    }


    /**
     * 同步一个类
     * 作用于同一个类对象,即同一个类的不同对象上,也进行同步
     */
    public void func() {
        synchronized(MySynchronized.class) {
            for (int i=0; i<10; i++) {
                System.out.print(i+ " ");
            }
        }
    }


    /**
     * 同步一个静态方法
     */
    public synchronized static void fun() {
        //todo
    }
}


