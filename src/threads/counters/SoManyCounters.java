package threads.counters;

import java.util.Scanner;

public class SoManyCounters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            Runnable counter = new RunnableCounter(i);
            Thread thread = new Thread(counter);
            thread.start();
        }
    }
}
