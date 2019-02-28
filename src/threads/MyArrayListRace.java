package threads;

import util.MyArrayList;
import util.MyList;

public class MyArrayListRace implements Runnable {

    private final MyList<Integer> numbers;
    private final int max;

    public MyArrayListRace(MyList<Integer> numbers, int max) {
        this.numbers = numbers;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i=0; i<max; i++) {
            numbers.add(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 10;
        int max = 1000;

        MyList<Integer> numbers = new MyArrayList<>(2);
        MyList<Thread> threads = new MyArrayList<>(10);
        for(int i=0; i<numberOfThreads; i++) {
            MyArrayListRace racer = new MyArrayListRace(numbers, max);
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
