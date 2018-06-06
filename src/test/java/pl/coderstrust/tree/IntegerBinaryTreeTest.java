package pl.coderstrust.tree;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class IntegerBinaryTreeTest extends MyBinaryTreeTest {

  @Override
  public MyBinaryTree getTree() {
    return new MyBinaryTree<Integer>();
  }

  @Override
  public void addShouldReturnTrueWhenNewElementsAdded() {
    Assert.assertThat(myBinaryTree.add(2), is(true));
    Assert.assertThat(myBinaryTree.add(5), is(true));
    Assert.assertThat(myBinaryTree.add(0), is(true));
    Assert.assertThat(myBinaryTree.add(9), is(true));
    Assert.assertThat(myBinaryTree.add(7), is(true));
  }

  @Override
  public void addShouldReturnFalseWhenTheSameElementAdded() {
    myBinaryTree.add(9);
    myBinaryTree.add(8);
    myBinaryTree.add(7);
    myBinaryTree.add(10);
    myBinaryTree.add(12);
    Assert.assertThat(myBinaryTree.add(10), is(false));
    Assert.assertThat(myBinaryTree.add(7), is(false));
  }

  @Override
  public void findShouldReturnTrueWhenIsElementInTree() {
    myBinaryTree.add(10);
    myBinaryTree.add(9);
    myBinaryTree.add(7);
    myBinaryTree.add(12);
    Assert.assertThat(myBinaryTree.find(10), is(true));
    Assert.assertThat(myBinaryTree.find(12), is(true));
  }

  @Override
  public void findShouldReturnFalseWhenNoElementInTree() {
    myBinaryTree.add(10);
    myBinaryTree.add(12);
    Assert.assertThat(myBinaryTree.find(13), is(false));
  }

  @Override
  public void removeShouldReturnTrueWhenElementRemoved() {
    myBinaryTree.add(2);
    myBinaryTree.add(5);
    myBinaryTree.add(0);
    myBinaryTree.add(9);
    myBinaryTree.add(7);
    Assert.assertThat(myBinaryTree.remove(5), is(true));
    System.out.println();
  }

  @Override
  public void removeShouldReturnFalseWhenNoElementInTree() {
    myBinaryTree.add(2);
    myBinaryTree.add(5);
    myBinaryTree.add(0);
    myBinaryTree.add(9);
    myBinaryTree.add(7);
    Assert.assertThat(myBinaryTree.remove(6), is(false));
  }

  @Override
  public void removeShouldReturnTrueWhenRemovingRoot() {
    myBinaryTree.add(2);
    myBinaryTree.add(5);
    myBinaryTree.add(0);
    myBinaryTree.add(9);
    myBinaryTree.add(7);
    Assert.assertThat(myBinaryTree.remove(2), is(true));
  }

  @Override
  public void printInorderShouldReturnList() {
    myBinaryTree.add(2);
    myBinaryTree.add(5);
    myBinaryTree.add(0);
    myBinaryTree.add(9);
    myBinaryTree.add(7);
    List<Integer> expectedResult = Arrays.asList(0, 2, 5, 7, 9);
    List<Integer> result = myBinaryTree.printInorder();
    Assert.assertThat(result, is(expectedResult));
  }

  @Override
  public void printPreOrderShouldReturnList() {
    myBinaryTree.add(2);
    myBinaryTree.add(5);
    myBinaryTree.add(0);
    myBinaryTree.add(9);
    myBinaryTree.add(7);
    List<Integer> expectedResult = Arrays.asList(2, 0, 5, 9, 7);
    List<Integer> result = myBinaryTree.printPreOrder();
    Assert.assertThat(result, is(expectedResult));
  }

  @Override
  public void printPostOrderShouldReturnList() {
    myBinaryTree.add(2);
    myBinaryTree.add(5);
    myBinaryTree.add(0);
    myBinaryTree.add(9);
    myBinaryTree.add(7);
    List<Integer> expectedResult = Arrays.asList(0, 7, 9, 5, 2);
    List<Integer> result = myBinaryTree.printPostOrder();
    Assert.assertThat(result, is(expectedResult));
  }
}
