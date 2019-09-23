package com.leetcode.thread;

class PrintNum implements Runnable {

    int num = 1;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        synchronized (this) {

            while (true) {
                notify();
                if (num <= 100) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": "+ num);
                    num++;
                }else
                    break;
            }
            try {
                wait();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Test4 {

    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();

        Thread thread1 = new Thread(printNum);
        Thread thread2 = new Thread(printNum);

        thread1.setName("A");
        thread2.setName("B");

        thread1.start();
        thread2.start();
    }

}
