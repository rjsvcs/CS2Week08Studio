package threads.lists;

import java.util.ArrayList;
import java.util.List;

public class JavaArrayListRacer implements Runnable {
    private final List<Integer> numbers;
    private final int max;

    public JavaArrayListRacer(List<Integer> numbers, int max) {
        this.numbers = numbers;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i=0; i<max; i++) {
            numbers.add(i);
        }
    }

    public static void race(List<Integer> numbers, int numberOfThreads, int max) throws InterruptedException {
        List<Thread> threads = new ArrayList<>(numberOfThreads);

        for(int i=0; i<numberOfThreads; i++) {
            JavaArrayListRacer racer = new JavaArrayListRacer(numbers, max);
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

    public static void main(String[] args) throws InterruptedException {
        race(new ArrayList<>(), 10, 1000);
    }
}
