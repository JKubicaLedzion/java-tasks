package pl.coderstrust.listimplementation;

import org.junit.Assert;
import org.junit.Before;

import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

import static org.hamcrest.core.Is.is;

public class LongArrayListTest extends GenericArrayListTest {

  private List<Long> list;

  @Override
  public List<Long> getEmptyList() {
    return new MyArrayList<>();
  }

  @Before
  public void setUpForLongList() {
    list = getEmptyList();
    list.add(20L);
    list.add(10L);
    list.add(15L);
  }

  @Override
  public void replaceAllShouldReturnChangedList() {
    UnaryOperator<Long> operator = i -> i * i;
    list.replaceAll(operator);
    Assert.assertThat(list.get(0), is(400L));
    Assert.assertThat(list.get(1), is(100L));
  }

  @Override
  public void sortShouldSortList() {
    list.sort(new MyLongComparator());
    Assert.assertThat(list.indexOf(10L), is(0));
    Assert.assertThat(list.indexOf(15L), is(1));
    Assert.assertThat(list.indexOf(20L), is(2));
  }

  private class MyLongComparator implements Comparator<Long> {
    @Override
    public int compare(Long l1, Long l2) {
      if (l1 == null || l2 == null) {
        return 0;
      }
      return (int) (l1 - l2);
    }
  }
}
