package pl.coderstrust.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ManyProducersOneConsumer {

  public static void main(String[] args) {

    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    Producer producer1 = new Producer(queue);
    Producer producer2 = new Producer(queue);
    Consumer consumer = new Consumer(queue);

    new Thread(producer1).start();
    new Thread(producer2).start();
    new Thread(consumer).start();
    System.out.println("Production and consumption started.");
  }
}
