package threads.waiting;

public class Deadlock implements Runnable {

    private final String name;
    private final Object lock1;
    private final Object lock2;

    public Deadlock(String name, Object lock1, Object lock2) {
        this.name = name;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(name + ": trying to get " + lock1 + "...");
            synchronized(lock1) {
                System.out.println(name +
                        ": got it! Trying to get " + lock2 + "...");
                synchronized(lock2) {
                    System.out.println(name + ": got it!");
                }
            }
        }
    }

    public static void main(String[] args) {
        Object first = "LOCK1";
        Object second = "LOCK2";

        new Thread(new Deadlock("dead1", first, second)).start();
        new Thread(new Deadlock("dead2", second, first)).start();
    }
}
