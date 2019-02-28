package threads;

public class CounterThread extends Thread {
    private final String name;

    public CounterThread(String name) {
        this.name = name;
    }

    public void run() {
        for(int i=1; i<101; i++) {
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) {
        Thread counter = new CounterThread("thread 1");
        counter.start();
    }
}
