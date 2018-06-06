package pl.coderstrust.listimplementation;

public class LongLinkedListTest extends MyLinkedListTest {

  @Override
  public MyLinkedList getEmptyList() {
    return new MyLinkedList<Long>();
  }
}
