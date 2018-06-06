package pl.coderstrust.listimplementation;

import java.util.Iterator;
import java.util.function.Consumer;

public class MyLinkedList<E> implements Iterable {

  private Node start;
  private Node end;
  private int size;

  @Override
  public MyIterator iterator() {
    return new MyIterator();
  }

  public boolean add(Object o) {
    Node newNode = new Node(o);
    Node current = end;
    end = newNode;
    if (current == null) {
      start = newNode;
    } else {
      current.next = end;
    }
    size++;
    return true;
  }

  public boolean remove(Object o) {
    if (checkIfListEmpty()) {
      return false;
    }

    if (start.value.equals(o)) {
      if (start == end) {
        end = null;
      }
      start = start.next;
      size--;
      return true;
    }

    Node temp = start;
    Node tempPrevious = temp;
    while (temp.value != o) {
      if (temp.next == null) {
        return false;
      }
      tempPrevious = temp;
      temp = temp.next;
    }

    movePointers(tempPrevious);
    size--;
    return true;
  }

  public boolean contains(Object o) {
    if (checkIfListEmpty()) {
      return false;
    }
    Node temp = start;
    while (temp.value != o) {
      if (temp.next == null) {
        return false;
      }
      temp = temp.next;
    }
    return true;
  }

  private void movePointers(Node node) {
    Node nodeNext = node.next;
    Node nextForNodeNext = nodeNext.next;
    node.next = nextForNodeNext;
    if (nodeNext == end) {
      end = node;
    }
  }

  private boolean checkIfListEmpty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }

  private static class Node<E> {

    private E value;
    private Node<E> next;

    Node(E value) {
      this.value = value;
      this.next = null;
    }
  }

  class MyIterator implements Iterator {

    private Node cursor;

    public MyIterator() {
      this.cursor = start;
    }

    @Override
    public boolean hasNext() {
      if (checkIfListEmpty()) {
        return false;
      }
      return cursor.next == null ? false : true;
    }

    @Override
    public Object next() {
      if (checkIfListEmpty()) {
        return null;
      }
      Node current = cursor;
      cursor = cursor.next;
      return current.value;
    }

    @Override
    public void remove() {
      if (checkIfListEmpty()) {
        return;
      }
      MyLinkedList.this.remove(cursor.value);
    }

    @Override
    public void forEachRemaining(Consumer action) {
      if (checkIfListEmpty()) {
        return;
      }
      while (hasNext()) {
        action.accept(cursor);
        cursor = cursor.next;
      }
      action.accept(end);
    }
  }
}
