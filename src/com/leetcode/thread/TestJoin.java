package com.leetcode.thread;

/**
 * 在线程中调用另一个线程的join()方法
 * 当前线程先挂起,而不是等待
 * 直到目标线程结束
 * <p>
 * <p>
 * 虽然 b 线程先启动,但是因为在 b 线程中调用了 a 线程的 join() 方法,b 线程会等待 a 线程结束才继
 * 续执行,因此最后能够保证 a 线程的输出先于 b 线程的输出
 */
public class TestJoin {

    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }


    private class B extends Thread {

        private A a;

        public B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test() {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

    public static void main(String[] args) {
        TestJoin example = new TestJoin();
        example.test();
    }

}
