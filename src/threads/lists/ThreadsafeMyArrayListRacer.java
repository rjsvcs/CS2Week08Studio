package threads.lists;

import util.ThreadsafeMyArrayList;

public class ThreadsafeMyArrayListRacer {
    public static void main(String[] args) throws InterruptedException {
        MyListRacer.race(new ThreadsafeMyArrayList<>(), 10, 1000);
    }
}
