public class SynchronizedClassStatic implements Runnable {
    static SynchronizedClassStatic instance1 = new SynchronizedClassStatic();
    static SynchronizedClassStatic instance2 = new SynchronizedClassStatic();

    @Override
    public void run() {
        method();
    }

    public static synchronized void method() {
        System.out.println("I am " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has finished");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }

}