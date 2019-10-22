package com.leetcode.dp;

public class TestMain {
    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        int [] a = new int[52];
        int index = 1;
        for (int i=1; i<a.length; i++) {
            a[0] = index;
            index++;
        }

        String[] b = {"A", "B", "C","" +
                "D" + "E", "F", "G" + "H", "I"};


        new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=1;i< 4 ;i++){
                    synchronized (object){
//                        System.out.println("线程a 开始执行");
                        object.notify();
                        try {
                            System.out.println(a[i]);
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