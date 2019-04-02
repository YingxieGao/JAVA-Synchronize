public class SynchronizedObjectCodeBlock implements Runnable {
    static SynchronizedObjectCodeBlock instance = new SynchronizedObjectCodeBlock();
    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {
        /**
         * 对象锁的代码块形式
         */
        synchronized (lock1) {
            System.out.println("I am lock 1 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock 1 part has finished");
        }

        synchronized (lock2) {
            System.out.println("I am lock 2 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock 2 part has finished");
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }

}