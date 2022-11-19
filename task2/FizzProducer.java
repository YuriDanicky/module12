package module12.task2;

import java.util.concurrent.BlockingQueue;

public class FizzProducer implements Runnable {
    BlockingQueue<String> queue;
    private int n;
    private boolean updated = false;

    public FizzProducer(BlockingQueue<String> queue) {
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
        try {
            while (true) {
                while (updated) {
                    updated = false;
                    if ((n % 3 == 0) && !(n % 5 == 0)) {
                        queue.put("fizz");
                        System.out.println("put fizz");
                    }
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
