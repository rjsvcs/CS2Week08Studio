package threads.counters;

public class CountdownTimer implements Runnable {
    @Override
    public void run() {
        int time = -10;
        while(true) {
            String t = time < 0 ? "T" : "T+";
            System.out.println(t + time);
            time++;
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ie) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new CountdownTimer();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
