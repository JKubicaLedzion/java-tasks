package pl.coderstrust.multithreading;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyBlockingQueue<E> implements BlockingQueue {

  private Queue<E> queue;
  private int maxSize;

  public MyBlockingQueue(int maxSize) {
    this.queue = new ArrayBlockingQueue<E>(maxSize);
    this.maxSize = maxSize;
  }

  @Override
  public void put(Object o) throws InterruptedException {
    synchronized (queue) {
      while (queue.size() == maxSize) {
        System.out.println("PRODUCER IS WAITING");
        queue.wait();
      }
      queue.add((E) o);
      queue.notifyAll();
    }
  }

  @Override
  public E take() throws InterruptedException {
    synchronized (queue) {
      while (queue.isEmpty()) {
        System.out.println("CONSUMER IS WAITING");
        queue.wait();
      }
      E element = queue.poll();
      queue.notifyAll();
      return element;
    }
  }

  @Override
  public boolean add(Object o) {
    return false;
  }

  @Override
  public boolean offer(Object o) {
    return false;
  }

  @Override
  public boolean offer(Object o, long timeout, TimeUnit unit) throws InterruptedException {
    return false;
  }

  @Override
  public Object poll(long timeout, TimeUnit unit) throws InterruptedException {
    return null;
  }

  @Override
  public int remainingCapacity() {
    return 0;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public int drainTo(Collection c) {
    return 0;
  }

  @Override
  public int drainTo(Collection c, int maxElements) {
    return 0;
  }

  @Override
  public Object remove() {
    return null;
  }

  @Override
  public Object poll() {
    return null;
  }

  @Override
  public Object element() {
    return null;
  }

  @Override
  public Object peek() {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public Iterator iterator() {
    return null;
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public Object[] toArray(Object[] a) {
    return new Object[0];
  }

  @Override
  public boolean containsAll(Collection c) {
    return false;
  }

  @Override
  public boolean addAll(Collection c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection c) {
    return false;
  }

  @Override
  public void clear() {}
}
