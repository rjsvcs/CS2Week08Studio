package threads.counters;

import util.TextColor;

public class CounterThread extends Thread {
    private final String name;

    public CounterThread(int number) {
        this.name = TextColor.getColorString(number) + "thread " + number;
    }

    public void run() {
        for(int i=1; i<101; i++) {
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) {
        Thread counter = new CounterThread(0);
        counter.start();
    }
}
