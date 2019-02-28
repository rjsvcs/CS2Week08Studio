package threads.waiting;

public class Evens implements Runnable {
    private final Odds odds;
    private final int n;

    private int current;

    public Evens(Odds lock, int n) {
        this.odds = lock;
        this.n = n;

        current = 2;
    }


    @Override
    public void run() {
        synchronized(odds) {
            if(!odds.printed()) {
                try {
                    odds.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while(current <= n) {
                System.out.println(current);
                current += 2;
                odds.notify();
                try {
                    odds.wait();
                } catch (InterruptedException e) {
                    // squash
                }
            }
            odds.notify();
        }
    }
}
