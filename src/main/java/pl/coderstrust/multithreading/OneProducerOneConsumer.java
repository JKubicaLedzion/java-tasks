package pl.coderstrust.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class OneProducerOneConsumer {

  public static void main(String[] args) {

    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    Producer producer = new Producer(queue);
    Consumer consumer = new Consumer(queue);

    new Thread(producer).start();
    new Thread(consumer).start();
    System.out.println("Production and consumption started.");
  }
}
