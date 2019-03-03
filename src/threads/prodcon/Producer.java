package threads.prodcon;

import java.util.Queue;

public class Producer implements Runnable {
    private final Queue<Integer> queue;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int n=0; n<Integer.MAX_VALUE; n++) {
            // do not block the queue while executing the primary task; we
            // don't want to prevent any consumers from doing their job
            int nth = fib(n);
            // obtain the lock when the job is ready
            synchronized(queue) {
                // add the job to the queue
                queue.add(nth);
                // notify any consumers that a job is ready
                queue.notifyAll();
            }
        }
    }

    /**
     * Performs a brute force computation of the Nth Fibonacci number. This
     * implementation was chosen specifically because it takes time.
     *
     * @param n The index of the desired number in the Fibonacci sequence.
     *
     * @return The Nth number in the Fibonacci sequence.
     */
    private static int fib(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

}
