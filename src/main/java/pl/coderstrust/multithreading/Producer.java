package pl.coderstrust.multithreading;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

  BlockingQueue<Integer> queue;

  public Producer(BlockingQueue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 100; i++) {
        queue.put(i);
        System.out.println("Produced element " + i);
      }
      System.out.println("Productions ends.");
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
