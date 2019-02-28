package threads.lists;

import util.MyArrayList;
import util.MyList;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedMyListRacer implements Runnable {
    private final MyList<Integer> numbers;

    public SynchronizedMyListRacer(MyList<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            // synchronized the call to add
            synchronized (numbers) {
                numbers.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyList<Integer> numbers = new MyArrayList<>();
        List<Thread> threads = new ArrayList<>(10);

        for(int i=0; i<10; i++) {
            SynchronizedMyListRacer racer =
                    new SynchronizedMyListRacer(numbers);
            Thread thread = new Thread(racer);
            thread.start();
            threads.add(thread);
        }

        for(Thread thread : threads) {
            thread.join();
        }

        System.out.println("Expected: " + (10 * 1000));
        System.out.println("Actual: " + numbers.size());
    }
}
