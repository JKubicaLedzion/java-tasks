package pl.coderstrust.listimplementation;

import junitparams.JUnitParamsRunner;
import org.hamcrest.junit.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public abstract class MyLinkedListTest<E> {

  @Rule public ExpectedException exception = ExpectedException.none();
  private MyLinkedList<E> list;
  private Object o1;
  private Object o2;
  private Object o3;
  private Iterator iterator;

  public abstract MyLinkedList<E> getEmptyList();

  @Before
  public void setUpDefault() {
    list = getEmptyList();
    o1 = new Object();
    o2 = new Object();
    o3 = new Object();
  }

  // TESTS for ITERATOR
  // TEST for boolean hasNext()
  @Test
  public void hasNextShouldReturnTrueWhenIsNextElement() {
    list.add((E) o1);
    list.add((E) o2);
    iterator = list.iterator();
    assertTrue(iterator.hasNext());
  }

  @Test
  public void hasNextShouldReturnFalseWhenNoNextElement() {
    iterator = list.iterator();
    assertFalse(iterator.hasNext());
  }

  // TEST for E next()
  @Test
  public void nextShouldReturnNextElement() {
    list.add((E) o1);
    iterator = list.iterator();
    assertThat(iterator.next(), is(o1));
  }

  @Test
  public void nextWhenNoElementReturnNull() {
    iterator = list.iterator();
    assertThat(iterator.next(), is((Object) null));
  }

  // TEST for remove()
  @Test
  public void removeShouldRemoveElement() {
    list.add((E) o1);
    list.add((E) o2);
    iterator = list.iterator();
    iterator.remove();
    assertThat(list.getSize(), is(1));
    assertThat(list.contains(o1), is(false));
    assertThat(list.contains(o2), is(true));
  }

  // TEST for boolean add(Object o)
  @Test
  public void addShouldAddElementsToEmptyListAndReturnTrue() {
    boolean result = list.add((E) o1);
    assertThat(list.getSize(), is(1));
    assertThat(result, is(true));
  }

  @Test
  public void addShouldAddElementsToListAndReturnTrue() {
    list.add((E) o1);
    boolean result = list.add((E) o2);
    assertThat(list.getSize(), is(2));
    assertThat(result, is(true));
  }

  // TEST for boolean remove(Object o)
  @Test
  public void removeShouldRemoveGivenElementAndReturnTrue() {
    list.add((E) o1);
    list.add((E) o2);
    boolean result = list.remove(o2);
    assertThat(list.getSize(), is(1));
    assertThat(list.contains(o1), is(true));
    assertThat(list.contains(o2), is(false));
    assertThat(result, is(true));
  }

  @Test
  public void removeAndAddShouldRemoveGivenElementAndAddNew() {
    list.add((E) o1);
    boolean result = list.remove(o1);
    list.add((E) o2);
    assertThat(list.getSize(), is(1));
    assertThat(list.contains(o1), is(false));
    assertThat(list.contains(o2), is(true));
    assertThat(result, is(true));
  }

  @Test
  public void removeShouldReturnFalseWhenListEmpty() {
    assertThat(list.remove(o1), is(false));
  }

  @Test
  public void removeShouldReturnFalseIfNoElementOnTheList() {
    list.add((E) o1);
    assertThat(list.remove(o2), is(false));
    assertThat(list.getSize(), is(1));
  }

  // TEST for boolean contains(Object o)
  @Test
  public void containsShouldReturnFalseIfEmptyList() {
    MyLinkedList<E> list = getEmptyList();
    assertThat(list.contains(o1), is(false));
  }

  @Test
  public void containsShouldReturnFalseIfNoElement() {
    list.add((E) o1);
    assertThat(list.contains(o2), is(false));
  }

  @Test
  public void containsShouldReturnTrueIfIsElement() {
    list.add((E) o1);
    assertThat(list.contains((E) o1), is(true));
  }
}
