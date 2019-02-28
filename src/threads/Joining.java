package threads;

import util.TextColor;

import java.util.ArrayList;
import java.util.List;

public class Joining {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>(5);
        for(int i=0; i<5; i++) {
            RunnableCounter counter = new RunnableCounter(i);
            Thread thread = new Thread(counter);
            thread.start();
            threads.add(thread);
        }

        for(Thread thread : threads) {
            thread.join();
        }
        System.out.println(TextColor.DEFAULT.getANSII() + "Finished!");
    }
}
