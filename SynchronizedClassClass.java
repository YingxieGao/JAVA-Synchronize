public class SynchronizedClassClass implements Runnable {
    static SynchronizedClassClass instance1 = new SynchronizedClassClass();
    static SynchronizedClassClass instance2 = new SynchronizedClassClass();

    @Override
    public void run() {
        try {
            method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void method() throws InterruptedException {
        synchronized (SynchronizedClassClass.class) {
            System.out.println("I am sysnchronized(*.class). " + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "has finished");
        }
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