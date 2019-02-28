package threads;

import util.MyList;
import util.ThreadsafeMyArrayList;

public class SafeRacer {
    public static void main(String[] args) throws InterruptedException {
        MyList<Integer> numbers = new ThreadsafeMyArrayList<>(2);

        MyArrayListRacer.race(numbers, 10, 1000);
    }
}
