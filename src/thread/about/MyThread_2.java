package thread.about;

public class MyThread_2 implements Runnable {
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
        //线程执行体
    }

    public static void main(String[] args) {
        MyThread_2 myThread = new MyThread_2();
        Thread t = new Thread(myThread);
        t.start();
    }
}
