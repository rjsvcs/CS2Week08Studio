package threads.waiting;

public class OddsAndEvens {
    public static void main(String[] args) {
        Odds odds = new Odds(100);
        new Thread(odds).start();

        Evens evens = new Evens(odds, 100);
        new Thread(evens).start();

    }
}
