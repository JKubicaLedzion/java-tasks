package pl.coderstrust.listimplementation;

import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public abstract class GenericArrayListTest<E> {

  @Rule public ExpectedException exception = ExpectedException.none();
  private List<E> list;
  private Collection<E> c;
  private Object o1;
  private Object o2;
  private Object o3;
  private Iterator iterator;
  private ListIterator listIterator;

  public abstract List<E> getEmptyList();

  @Before
  public void setUpDefault() {
    list = getEmptyList();
    c = new ArrayList<>();
    o1 = new Object();
    o2 = new Object();
    o3 = new Object();
    iterator = list.iterator();
    listIterator = list.listIterator();
  }

  // TEST for int size()
  @Test
  public void sizeShouldReturnZeroForEmptyList() {
    assertThat(list.size(), is(0));
  }

  @Test
  public void sizeShouldReturnZeroForListWithoutElements() {
    assertThat(list.size(), is(0));
  }

  @Test
  public void sizeShouldReturnSizeForListWithElements() {
    list.add((E) o1);
    list.add((E) o2);
    assertThat(list.size(), is(2));
  }

  // TEST for boolean isEmpty()
  @Test
  public void isEmptyShouldReturnTrueIfNoElements() {
    assertThat(list.isEmpty(), is(true));
  }

  @Test
  public void isEmptyShouldReturnFalseWhenElementsAdded() {
    list.add((E) o1);
    list.add((E) o2);
    assertThat(list.isEmpty(), is(false));
  }

  // TEST for boolean contains(Object o)
  @Test
  public void containsShouldReturnFalseIfNoElement() {
    List<E> list = getEmptyList();
    assertThat(list.contains(o1), is(false));
  }

  @Test
  public void containsShouldReturnTrueIfIsElement() {
    list.add((E) o1);
    assertThat(list.contains((E) o1), is(true));
  }

  // TESTS for ITERATOR
  // TEST for boolean hasNext()
  @Test
  public void hasNextShouldReturnTrueWhenIsNextElement() {
    list.add((E) o1);
    list.add((E) o2);
    assertTrue(iterator.hasNext());
  }

  @Test
  public void hasNextShouldReturnFalseWhenNoNextElement() {
    assertFalse(iterator.hasNext());
  }

  // TEST for E next()
  @Test
  public void nextShouldReturnNextElement() {
    list.add((E) o1);
    assertThat(iterator.next(), is(o1));
  }

  @Test
  public void nextWhenNoNextElementExceptionThrown() {
    exception.expect(NoSuchElementException.class);
    exception.expectMessage("No next element.");
    iterator.next();
  }

  // TEST for remove()
  @Test
  public void removeShouldRemoveElement() {
    list.add((E) o1);
    list.add((E) o2);
    iterator = list.iterator();
    iterator.next();
    iterator.remove();
    assertThat(list.size(), is(1));
    assertThat(list.indexOf(o1), is(0));
  }

  @Test
  public void removeWhenNextWasNotCalledExceptionThrown() {
    list.add((E) o1);
    list.add((E) o2);
    exception.expect(IllegalStateException.class);
    iterator.remove();
  }

  // TEST for Object[] toArray()
  @Test
  public void toArrayShouldReturnArrayOfElements() {
    Object[] expectedResult = new Object[] {o1, o2};
    list.add((E) o1);
    list.add((E) o2);
    assertThat(list.toArray(), is(expectedResult));
  }

  // TEST for Object[] toArray() (Object[] injava)
  @Test
  public void toArrayWithGivenCollectionShouldReturnArrayOfElements() {
    Object[] expectedResult = new Object[] {o1, o2};
    list.add((E) o1);
    list.add((E) o2);
    c.add((E) o3);
    c.add((E) o1);
    c.add((E) o2);
    assertThat(list.toArray(), is(expectedResult));
  }

  // TEST for boolean add(Object o)
  @Test
  public void addShouldAddElementsToList() {
    list.add((E) o1);
    assertThat(list.size(), is(1));
    assertThat(list.isEmpty(), is(false));
  }

  @Test
  public void addShouldAddElementsToListAndDoubledArrayLength() {
    for (int i = 0; i < 11; i++) {
      list.add((E) new Object());
    }
    assertThat(list.size(), is(11));
  }

  // TEST for boolean remove(Object o)
  @Test
  public void removeShouldRemoveGivenElementAndReturnTrue() {
    list.add((E) o1);
    list.add((E) o2);
    boolean result = list.remove(o1);
    assertThat(list.size(), is(1));
    assertThat(list.indexOf(o2), is(0));
    assertThat(result, is(true));
  }

  @Test
  public void removeShouldReturnFalseWhenListEmpty() {
    list.remove(o1);
    assertThat(list.remove(o1), is(false));
  }

  @Test
  public void removeShouldReturnFalseIfNoElementOnTheList() {
    list.add((E) o1);
    assertThat(list.remove(o2), is(false));
    assertThat(list.size(), is(1));
  }

  // TEST for boolean containsAll(Collection c)
  @Test
  public void containsAllShouldReturnFalseIfNotAllElementsOnTheList() {
    c.add((E) o1);
    c.add((E) o2);
    list.add((E) o1);
    assertThat(list.containsAll(c), is(false));
  }

  @Test
  public void containsAllShouldReturnTrueIfAllElementsOnTheList() {
    c.add((E) o1);
    c.add((E) o2);
    list.add((E) o1);
    list.add((E) o2);
    assertThat(list.containsAll(c), is(true));
  }

  // TEST for boolean addAll(Collection c)
  @Test
  public void addAllShouldAddCollectionAtTheEndOfList() {
    list.add((E) o1);
    c.add((E) o2);
    c.add((E) o3);
    list.addAll(c);
    assertThat(list.size(), is(3));
    assertThat(list.indexOf(o3), is(2));
  }

  // TEST for boolean addAll(int index, Collection c)
  @Test
  public void addAllShouldAddCollectionAtSpecificIndex() {
    Object o1 = new Object();
    list.add((E) o1);
    c.add((E) o2);
    c.add((E) o3);
    list.addAll(0, c);
    assertThat(list.size(), is(3));
    assertThat(list.indexOf(o1), is(2));
  }

  // TEST for boolean removeAll(Collection c)
  @Test
  public void removeAllShouldRemoveGivenCollection() {
    list.add((E) o1);
    list.add((E) o2);
    list.add((E) o3);
    c.add((E) o1);
    c.add((E) o3);
    boolean result = list.removeAll(c);
    assertThat(list.size(), is(1));
    assertThat(list.indexOf(o2), is(0));
    assertThat(result, is(true));
  }

  @Test
  public void removeAllShouldReturnFalseWhenListEmpty() {
    c.add((E) o2);
    c.add((E) o3);
    list.remove(c);
    assertThat(list.remove(c), is(false));
  }

  // TEST for boolean retainAll(Collection c)
  @Test
  public void retainAllShouldReturnTrueWhenListWasModified() {
    list.add((E) o1);
    list.add((E) o2);
    list.add((E) o3);
    c.add((E) o2);
    c.add((E) o3);
    boolean result = list.retainAll(c);
    assertThat(list.size(), is(2));
    assertThat(list.indexOf(o2), is(0));
    assertThat(result, is(true));
  }

  @Test
  public void retainAllShouldReturnFalseWhenEmptyList() {
    c.add((E) o2);
    boolean result = list.retainAll(c);
    assertThat(result, is(false));
  }

  // TEST for clear()
  @Test
  public void clearShouldRemoveAllElements() {
    list.add((E) o1);
    list.add((E) o2);
    list.clear();
    assertThat(list.isEmpty(), is(true));
    assertThat(list.size(), is(0));
  }

  // TEST for Object get(int index)
  @Test(expected = IndexOutOfBoundsException.class)
  public void getWhenWrongIndexExceptionThrown() {
    list.add((E) o1);
    list.get(1);
  }

  @Test
  public void getWhenCorrectIndexElementReturned() {
    list.add((E) o1);
    list.add((E) o2);
    assertThat(list.get(1), is(o2));
  }

  // TEST for Object set(int index, Object element)
  @Test
  public void setShouldAddElementAtGivenIndexAndReturnOldElementFromThatIndex() {
    list.add((E) o1);
    list.add((E) o2);
    assertThat(list.set(0, (E) o3), is(o1));
    assertThat(list.indexOf(o3), is(0));
  }

  // TEST fo boolean add(int index, Object element)
  @Test
  public void addShouldAddElementAtGivenIndex() {
    list.add((E) o1);
    list.add((E) o2);
    list.add(0, (E) o3);
    assertThat(list.indexOf(o1), is(1));
    assertThat(list.indexOf(o2), is(2));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void addWhenWrongIndexExceptionThrown() {
    list.add(1, (E) o1);
  }

  // TEST for E remove(int index)
  @Test
  public void removeShouldReturnedRemovedElement() {
    list.add((E) o1);
    assertThat(list.remove(0), is(o1));
  }

  // TEST for int indexOf(Object o)
  @Test
  public void indexOfShouldReturnNegativeNumberWhenElementNotFound() {
    list.add((E) o1);
    assertThat(list.indexOf(o2), is(-1));
  }

  @Test
  public void indexOfShouldReturnIndexOfElement() {
    list.add((E) o1);
    assertThat(list.indexOf(o1), is(0));
  }

  // TEST for int lastIndexOf(Object o)
  @Test
  public void lastIndexOfShouldReturnLastIndexOfElement() {
    list.add((E) o1);
    list.add((E) o2);
    list.add((E) o1);
    assertThat(list.lastIndexOf(o1), is(2));
  }

  @Test
  public void lastIndexOfShouldReturnNegativeNumberWhenElementNotFound() {
    list.add((E) o2);
    assertThat(list.lastIndexOf(o1), is(-1));
  }

  // TESTS for LISTITERATOR
  // TEST for boolean hasPrevious()
  @Test
  public void hasPreviousShouldReturnTrueWhenIsPreviousElement() {
    list.add((E) o1);
    list.add((E) o2);
    listIterator.next();
    assertThat(listIterator.hasPrevious(), is(true));
  }

  @Test
  public void hasPreviousShouldReturnFalseWhenNoPreviousElement() {
    list.add((E) o1);
    assertThat(listIterator.hasPrevious(), is(false));
  }

  // TEST for Object previous()
  @Test
  public void previousShouldReturnPreviousElement() {
    list.add((E) o1);
    list.add((E) o2);
    listIterator.next();
    assertThat(listIterator.previous(), is(o1));
  }

  // TEST for int nextIndex()
  @Test
  public void nextIndexWhenIsNextElementShouldReturnNextElementIndex() {
    list.add((E) o1);
    assertThat(listIterator.nextIndex(), is(0));
  }

  @Test
  public void nextIndexWhenNoNextElementShouldReturnSize() {
    list.add((E) o1);
    listIterator.next();
    assertThat(listIterator.nextIndex(), is(1));
  }

  // TEST for int previousIndex()
  @Test
  public void previousIndexWhenIsPreviousElementShouldReturnNextElementIndex() {
    list.add((E) o1);
    listIterator.next();
    assertThat(listIterator.previousIndex(), is(0));
  }

  @Test
  public void previousIndexWhenNoPreviousElementShouldReturnNegativeAmount() {
    list.add((E) o1);
    assertThat(listIterator.previousIndex(), is(-1));
  }

  // TEST for List subList(int startIndex, int endIndex)
  @Test
  public void subListWhenWrongIndexExceptionThrown() {
    list.add((E) o1);
    list.add((E) o2);
    list.add((E) o3);
    exception.expect(IndexOutOfBoundsException.class);
    exception.expectMessage("end index = 5");
    list.subList(4, 5);
  }

  @Test
  public void subListWhenCorrectIndexesSubListReturned() {
    list.add((E) o1);
    list.add((E) o2);
    list.add((E) o3);
    List<E> sublist = list.subList(0, 1);
    assertThat(sublist.contains(o1), is(true));
    assertThat(sublist.contains(o2), is(false));
    assertThat(sublist.contains(o3), is(false));
  }

  // TEST for replaceAll(UnaryOperator operator)
  @Test
  public abstract void replaceAllShouldReturnChangedList();

  // TEST for sort(Comparator c)
  @Test
  public abstract void sortShouldSortList();
}
