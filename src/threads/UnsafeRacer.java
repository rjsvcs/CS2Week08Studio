package threads;

import util.MyArrayList;
import util.MyList;

public class UnsafeRacer {
    public static void main(String[] args) throws InterruptedException {
        MyList<Integer> numbers = new MyArrayList<>(2);

        MyArrayListRacer.race(numbers, 10, 1000);
    }
}
