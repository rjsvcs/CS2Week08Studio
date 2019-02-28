package threads.lists;

import util.MyArrayList;

public class MyArrayListRacer {
    public static void main(String[] args) throws InterruptedException {
        MyListRacer.race(new MyArrayList<>(), 10, 1000);
    }
}
