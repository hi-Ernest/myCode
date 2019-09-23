package com.leetcode.thread;

/*wait():令当前线程放弃了cpu的资源，使别的线程可以访问共享的资源，
 *       而当前的线程排队等待，再次对资源的访问
 * notify():唤醒正在排队的等待的同步资源的线程，
 * notifyAll()：唤醒正在排队等待的所有的线程
 *
 *在 java.lang.Object:
 *用这三个方法的注意点：  同步方法或者同步代码块里
 *
 * 使用两个线程打印1----100.线程1和线程2交替打印
 *
 * 分析： 1.我先使用两个线程打印1---100，（先不用交替打印）
 *     2.然后在使用上面的三个方法，在代码里添加
 * */
public class TestMain {
    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=1;i< 4 ;i++){
                    synchronized (object){
//                        System.out.println("线程a 开始执行");
                        object.notify();
                        try {
//                            System.out.println("线程a 开始等待");
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        System.out.println("线程a 继续执行");
                        System.out.println("a " + i);
//                        System.out.println("线程a 执行结束");
                        object.notify();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=1;i<4;i++){
                    synchronized (object){
//                        System.out.println("线程1 开始执行");
                        object.notify();
                        try {
//                            System.out.println("线程1 开始等待");
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        System.out.println("线程1  继续执行");
                        System.out.println("b " + i);
//                        System.out.println("线程1  执行结束");
                    }
                }

            }
        }).start();
    }
}


class Tesst {

    static final Object obj = new Object();

    public static void main(String[] args) throws InterruptedException{
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<=3; i++) {
                    synchronized (obj) {
                        obj.notify();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("A: "+ i);
                        obj.notify();
                    }
                }
            }
        }).start();
    }
}