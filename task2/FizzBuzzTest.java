package module12.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzTest {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        NumberProducer numberProducer = new NumberProducer(queue);
        FizzProducer fizzProducer = new FizzProducer(queue);
        BuzzProducer buzzProducer = new BuzzProducer(queue);
        FizzBuzzProducer fizzBuzzProducer = new FizzBuzzProducer(queue);
        ConsumerFB consumerFB = new ConsumerFB(queue);

        executor.execute(numberProducer);
        executor.execute(fizzProducer);
        executor.execute(buzzProducer);
        executor.execute(fizzBuzzProducer);
        executor.execute(consumerFB);

        for (int i = 1; i < 30; i++) {
            numberProducer.setN(i);
            fizzProducer.setN(i);
            buzzProducer.setN(i);
            fizzBuzzProducer.setN(i);

            while (numberProducer.isUpdated() ||
                    (fizzProducer.isUpdated()) ||
                    (buzzProducer.isUpdated()) ||
                    (fizzBuzzProducer.isUpdated())) {
                Thread.sleep(10);
            }
        }
    }
}
