package pl.coderstrust.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class OneProducerManyConsumers {

  public static void main(String[] args) {

    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    Producer producer = new Producer(queue);
    Consumer consumer1 = new Consumer(queue);
    Consumer consumer2 = new Consumer(queue);

    new Thread(producer).start();
    new Thread(consumer1).start();
    new Thread(consumer2).start();
    System.out.println("Production and consumption started.");
  }
}
