package pl.coderstrust.listimplementation;

import org.junit.Assert;
import org.junit.Before;

import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

import static org.hamcrest.core.Is.is;

public class IntegerArrayListTest extends GenericArrayListTest {

  private List<Integer> list;

  @Override
  public List<Integer> getEmptyList() {
    return new MyArrayList<>();
  }

  @Before
  public void setUpForLongList() {
    list = getEmptyList();
    list.add(20);
    list.add(10);
    list.add(15);
  }

  @Override
  public void replaceAllShouldReturnChangedList() {
    UnaryOperator<Integer> operator = i -> i * i;
    list.replaceAll(operator);
    Assert.assertThat(list.get(0), is(400));
    Assert.assertThat(list.get(1), is(100));
  }

  @Override
  public void sortShouldSortList() {
    list.sort(new IntegerArrayListTest.MyIntegerComparator());
    Assert.assertThat(list.indexOf(10), is(0));
    Assert.assertThat(list.indexOf(15), is(1));
    Assert.assertThat(list.indexOf(20), is(2));
  }

  private class MyIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
      if (i1 == null || i2 == null) {
        return 0;
      }
      return (int) (i1 - i2);
    }
  }
}
