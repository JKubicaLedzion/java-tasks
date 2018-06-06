package pl.coderstrust.multithreading;

public class OneProducerOneConsumerUsingMyQueue {

  public static void main(String[] args) {

    MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);

    Producer producer = new Producer(queue);
    Consumer consumer = new Consumer(queue);

    new Thread(producer).start();
    new Thread(consumer).start();

    System.out.println("Production and consumption started.");
  }
}
