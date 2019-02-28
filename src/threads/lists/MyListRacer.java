package threads.lists;

import util.MyList;

import java.util.ArrayList;
import java.util.List;

public class MyListRacer implements Runnable {
    private final MyList<Integer> numbers;
    private final int max;

    MyListRacer(MyList<Integer> numbers, int max) {
        this.numbers = numbers;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i=0; i<max; i++) {
            numbers.add(i);
        }
    }

    public static void race(MyList<Integer> numbers, int numberOfThreads,
                             int max) throws InterruptedException {
        List<Thread> threads = new ArrayList<>(numberOfThreads);
        for(int n=0; n<numberOfThreads; n++) {
            MyListRacer racer = new MyListRacer(numbers, max);
            Thread thread = new Thread(racer);
            thread.start();
            threads.add(thread);
        }

        for(Thread thread : threads) {
            thread.join();
        }

        System.out.println("Expected: " + (numberOfThreads * max));
        System.out.println("Actual: " + numbers.size());
    }
}
