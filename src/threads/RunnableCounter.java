package threads;

public class RunnableCounter implements Runnable {
    private final String name;

    public RunnableCounter(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=1; i<101; i++) {
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) {
        Runnable counter = new RunnableCounter("runnable 1");
        Thread thread = new Thread(counter);
        thread.start();
    }
}
