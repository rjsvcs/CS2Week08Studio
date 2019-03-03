package threads.waiting;

public class TagTeam implements Runnable {
    private final String name;
    private final Object sharedLock;

    public TagTeam(String name, Object sharedLock) {
        this.name = name;
        this.sharedLock = sharedLock;
    }

    @Override
    public void run() {
        synchronized(sharedLock) {
            for(int count=0; count<10; count++) {
                System.out.println(name + " has obtained the lock!");
                System.out.println("  notifying...");
                sharedLock.notify();
                System.out.println("  sleeping...");
                try {
                    Thread.sleep(250);
                    System.out.println("  waiting...");
                    sharedLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object sharedLock = new Object();
        for(int i=0; i<5; i++) {
            TagTeam tt = new TagTeam("Thread " + i, sharedLock);
            new Thread(tt).start();
        }
    }
}
