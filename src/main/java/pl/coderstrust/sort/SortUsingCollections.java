package pl.coderstrust.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortUsingCollections implements SortingMethod {

  @Override
  public int[] sort(int[] array) {
    List<Integer> list = Arrays.stream(array).sorted().boxed().collect(Collectors.toList());
    return list.stream().mapToInt(Integer::intValue).toArray();
  }
}
