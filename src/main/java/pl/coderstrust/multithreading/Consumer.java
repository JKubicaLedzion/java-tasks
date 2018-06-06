package pl.coderstrust.multithreading;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

  BlockingQueue<Integer> queue;

  public Consumer(BlockingQueue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    try {
      while (true) {
        int element = queue.take();
        System.out.println("Consumed element " + element);
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
