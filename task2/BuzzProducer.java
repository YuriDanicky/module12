package module12.task2;

import java.util.concurrent.BlockingQueue;

public class BuzzProducer implements Runnable {
    BlockingQueue<String> queue;
    private int n;
    private boolean updated = false;

    public BuzzProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void setN(int n) {
        this.n = n;
        updated = true;
    }

    public boolean isUpdated() {
        return updated;
    }

    @Override
    public void run() {
        while (true) {
            while (updated) {
                updated = false;
                if (!(n % 3 == 0) && (n % 5 == 0)) {
                    try {
                        queue.put("buzz");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
