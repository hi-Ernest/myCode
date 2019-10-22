package com.leetcode.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 调用 wait() 使得线程等待某个条件满足,线程在等待时会被挂起,当其他线程的运行使得这个条件满足时,其它线程
 * 会调用 notify() 或者 notifyAll() 来唤醒挂起的线程。
 * <p>
 * 它们都属于 Object 的一部分,而不属于 Thread。
 * <p>
 * 只能用在同步方法或者同步控制块中使用,否则会在运行时抛出 IllegalMonitorStateException。
 * <p>
 * 使用 wait() 挂起期间,线程会释放锁。这是因为,如果没有释放锁,那么其它线程就无法进入对象的同步方法或者同
 * 步控制块中,那么就无法执行 notify() 或者 notifyAll() 来唤醒挂起的线程,造成死锁。
 */
public class WaitExample {

    public synchronized void before() {
        System.out.println("before");
//        notifyAll();
        notify();
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        WaitExample example = new WaitExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());
    }
}
