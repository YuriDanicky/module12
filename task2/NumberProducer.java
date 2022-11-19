package module12.task2;

import java.util.concurrent.BlockingQueue;

public class NumberProducer implements Runnable {

    BlockingQueue<String> queue;
    private int n;
    private boolean updated = false;

    public NumberProducer(BlockingQueue<String> queue) {
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
            try {
                while (updated) {
                    updated = false;
                    if ((n % 3 != 0) && (n % 5 != 0)) {
                        queue.put(String.valueOf(n));
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

