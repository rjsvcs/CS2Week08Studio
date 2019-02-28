package threads.waiting;

public class Odds implements Runnable {
    private final int n;

    private int current;
    private boolean printed;

    public Odds(int n) {
        this.n = n;

        current = 1;
        printed = false;
    }

    public synchronized boolean printed() {
        return printed;
    }

    @Override
    public synchronized  void run() {
        while(current <= n) {
            System.out.println(current);
            current += 2;
            printed = true;
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                // squash
            }
        }
        notify();
    }
}
