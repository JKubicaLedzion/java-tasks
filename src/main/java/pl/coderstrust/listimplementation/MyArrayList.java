package pl.coderstrust.listimplementation;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class MyArrayList<E> implements List<E> {

  private static final int INITIAL_SIZE = 10;
  private int size;
  private Object[] arrayOfElements;

  public MyArrayList() {
    arrayOfElements = new Object[INITIAL_SIZE];
    size = 0;
  }

  private static void indexValidityCheck(int index, int size) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index = " + index);
    }
  }

  private static void indexesValidityCheck(int startIndex, int endIndex, int size) {
    if (startIndex < 0) {
      throw new IndexOutOfBoundsException("start index = " + startIndex);
    }
    if (endIndex > size) {
      throw new IndexOutOfBoundsException("end index = " + endIndex);
    }
    if (startIndex > endIndex) {
      throw new IllegalArgumentException(
          "start index = " + startIndex + " > end index = " + endIndex);
    }
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    return indexOf(o) != -1;
  }
  // END

  @Override
  public MyArrayIterator<E> iterator() {
    return new MyArrayIterator<>();
  }

  @Override
  public Object[] toArray() {
    return Arrays.copyOf(arrayOfElements, size);
  }

  @Override
  public Object[] toArray(Object[] a) {
    if (a.length < size) {
      return Arrays.copyOf(arrayOfElements, size, a.getClass());
    }
    System.arraycopy(arrayOfElements, 0, a, 0, size);
    if (a.length > size) {
      for (int i = a.length - 1; i > size - 1; i--) {
        a[i] = null;
      }
    }
    return a;
  }

  @Override
  public boolean add(Object o) {
    if (size == arrayOfElements.length) {
      increaseArrayLength();
      arrayOfElements[++size] = o;
      return true;
    } else {
      arrayOfElements[size++] = o;
      return true;
    }
  }

  @Override
  public boolean remove(Object o) {
    if (size == 0) {
      return false;
    }
    for (int i = 0; i < size; i++) {
      if (arrayOfElements[i].equals(o)) {
        moveElementsToTheLeft(i);
        size--;
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean containsAll(Collection c) {
    for (Object e : c) {
      if (!contains(e)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection c) {
    for (Object e : c) {
      add(e);
    }
    return true;
  }

  @Override
  public boolean addAll(int index, Collection c) {
    indexValidityCheck(index, size);
    moveElementsToTheRight(c.size(), index);

    for (Object o : c) {
      add(index++, o);
    }
    return false;
  }

  @Override
  public boolean removeAll(Collection c) {
    if (checkIfCollectionOrListIsEmpty(c)) {
      return false;
    }

    boolean listChanged = false;
    for (int i = 0; i < size; i++) {
      if (c.contains(arrayOfElements[i])) {
        moveElementsToTheLeft(i);
        listChanged = true;
        size--;
      }
    }
    return listChanged;
  }

  @Override
  public boolean retainAll(Collection c) {
    if (checkIfCollectionOrListIsEmpty(c)) {
      return false;
    }

    boolean listChanged = false;
    List<Object> newList = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      if (c.contains(arrayOfElements[i])) {
        newList.add(arrayOfElements[i]);
        listChanged = true;
      }
    }
    size = newList.size();
    arrayOfElements = newList.toArray();
    return listChanged;
  }

  @Override
  public void clear() {
    for (int i = size - 1; i > -1; i--) {
      arrayOfElements[i] = null;
    }
    size = 0;
  }

  @Override
  public E get(int index) {
    indexValidityCheck(index, size);
    return (E) arrayOfElements[index];
  }

  @Override
  public Object set(int index, Object element) {
    indexValidityCheck(index, size);
    Object oldElement = arrayOfElements[index];
    arrayOfElements[index] = element;
    return oldElement;
  }

  @Override
  public void add(int index, Object element) {
    indexValidityCheck(index, size);
    moveElementsToTheRight(1, index);
    size++;
    arrayOfElements[index] = element;
  }

  @Override
  public E remove(int index) {
    indexValidityCheck(index, size);
    Object oldValue = arrayOfElements[index];
    moveElementsToTheLeft(index);
    size--;
    return (E) oldValue;
  }

  @Override
  public int indexOf(Object o) {
    for (int i = 0; i < size; i++) {
      if (arrayOfElements[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    for (int i = size - 1; i > -1; i--) {
      if (arrayOfElements[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public MyArrayListIterator listIterator() {
    return new MyArrayListIterator();
  }
  // END

  @Override
  public MyArrayListIterator listIterator(int index) {
    return new MyArrayListIterator(index);
  }

  @Override
  public List subList(int startIndex, int endIndex) {
    indexesValidityCheck(startIndex, endIndex, size);
    Object[] subArray = ArrayUtils.subarray(arrayOfElements, startIndex, endIndex);
    return Arrays.stream(subArray).collect(Collectors.toList());
  }

  @Override
  public void replaceAll(UnaryOperator operator) {
    for (int i = 0; i < size; i++) {
      arrayOfElements[i] = operator.apply(arrayOfElements[i]);
    }
  }

  @Override
  public void sort(Comparator c) {
    Arrays.sort(arrayOfElements, c);
  }

  // Auxiliary methods
  private void increaseArrayLength() {
    arrayOfElements = Arrays.copyOf(arrayOfElements, arrayOfElements.length * 2);
  }

  private void moveElementsToTheRight(int moveSteps, int index) {
    while (arrayOfElements.length < size + moveSteps) {
      increaseArrayLength();
    }
    for (int i = size - 1; i >= index; i--) {
      arrayOfElements[i + moveSteps] = arrayOfElements[i];
    }
  }

  private void moveElementsToTheLeft(int index) {
    for (int i = index; i < size - 1; i++) {
      arrayOfElements[i] = arrayOfElements[i + 1];
    }
    arrayOfElements[size - 1] = null;
  }

  private boolean checkIfCollectionOrListIsEmpty(Collection c) {
    return c.size() == 0 || size == 0;
  }

  // ITERATOR IMPLEMENTATION
  class MyArrayIterator<E> implements Iterator<E> {

    protected int cursor;
    private int lastReturned = -1;

    public MyArrayIterator() {
      this.cursor = 0;
    }

    public MyArrayIterator(int index) {
      super();
      indexValidityCheck(index, size);
      cursor = index;
    }

    @Override
    public boolean hasNext() {
      return cursor != size;
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException("No next element.");
      }
      lastReturned = cursor;
      return (E) arrayOfElements[cursor++];
    }

    @Override
    public void remove() {
      if (lastReturned < 0) {
        throw new IllegalStateException();
      } else {
        MyArrayList.this.remove(cursor);
        lastReturned = -1;
      }
    }
  }

  // ListIterator IMPLEMENTATION
  class MyArrayListIterator extends MyArrayIterator implements ListIterator {

    public MyArrayListIterator() {
      super();
    }

    public MyArrayListIterator(int index) {
      super(index);
    }

    @Override
    public boolean hasPrevious() {
      return cursor > 0;
    }

    @Override
    public Object previous() {
      if (!hasNext()) {
        throw new NoSuchElementException("No next element.");
      }
      return arrayOfElements[--cursor];
    }

    @Override
    public int nextIndex() {
      if (cursor == size) {
        return size;
      }
      return cursor;
    }

    @Override
    public int previousIndex() {
      if (!hasPrevious()) {
        return -1;
      }
      return cursor - 1;
    }

    @Override
    public void set(Object o) {
      MyArrayList.this.set(cursor, o);
    }

    @Override
    public void add(Object o) {
      MyArrayList.this.add(cursor, o);
    }
  }
}
