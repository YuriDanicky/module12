package module12.task2;

import java.util.concurrent.BlockingQueue;

public class ConsumerFB implements Runnable {

    BlockingQueue<String> queue;

    public ConsumerFB(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            while (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

