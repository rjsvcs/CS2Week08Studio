package threads.prodcon;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;

public class Consumer implements Runnable {
    /**
     * The format of the time/date used in log messages.
     */
    private static final String DATE_FORMAT_STRING = "YYYY/MM/dd HH:mm:ss.SSS";

    /**
     * The {@link DateFormat} used to properly format the current date for
     * printing.
     */
    private static final DateFormat DATE_FORMAT =
            new SimpleDateFormat(DATE_FORMAT_STRING);

    private final Queue<Integer> queue;
    private final String filename;

    public Consumer(Queue<Integer> queue, String filename) {
        this.queue = queue;
        this.filename = filename;
    }

    @Override
    public void run() {
        boolean sentinel = true;

        while(sentinel) {
            int job;
            synchronized(queue) {
                // if the queue is empty...
                if(queue.size() == 0) {
                    // wait (and release the lock)
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        // stop working
                        sentinel = false;
                    }
                }
                // get the next job and then immediately exit the synchronized
                // block to give up the lock (we don't want to block the
                // producer).
                System.out.println("jobs waiting: " + queue.size());
                job = queue.poll();
            }

            // this work is done outside the synchronized block so as to
            // prevent the producer from being blocked the next time it
            // tries to add a job to the queue
            sentinel = writeLog(job);

        }
    }

    private boolean writeLog(int prime) {
        // append to an existing file
        try(Writer writer = new FileWriter(filename, true)) {
            // create the job log and write it
            String date = DATE_FORMAT.format(new Date());
            String message = date + ": " + prime + "\n";
            char[] chars = message.toCharArray();
            writer.write(chars);
            writer.flush();
            return true;

        } catch(IOException ioe) {
            // terminate the consumer if an IO Exception occurs
            ioe.printStackTrace();
            return false;
        }
    }
}
