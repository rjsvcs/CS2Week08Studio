package threads.prodcon;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue);
        new Thread(producer).start();

        String filename = "log" + System.currentTimeMillis() + ".txt";
        Consumer consumer = new Consumer(queue, filename);
        new Thread(consumer).start();
    }
}
