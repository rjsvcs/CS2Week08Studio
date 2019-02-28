package threads;

import util.MyArrayList;
import util.MyList;

public class MyArrayListRacer implements Runnable {

    private final MyList<Integer> numbers;
    private final int max;

    public MyArrayListRacer(MyList<Integer> numbers, int max) {
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
        MyList<Thread> threads = new MyArrayList<>(numberOfThreads);
        for(int i=0; i<numberOfThreads; i++) {
            MyArrayListRacer racer = new MyArrayListRacer(numbers, max);
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
