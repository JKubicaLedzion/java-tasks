package pl.coderstrust.tree;

import org.junit.Before;
import org.junit.Test;

public abstract class MyBinaryTreeTest<E> {

  MyBinaryTree myBinaryTree;

  public abstract MyBinaryTree getTree();

  @Before
  public void setUp() {
    myBinaryTree = getTree();
  }

  @Test
  public abstract void addShouldReturnTrueWhenNewElementsAdded();

  @Test
  public abstract void addShouldReturnFalseWhenTheSameElementAdded();

  @Test
  public abstract void findShouldReturnTrueWhenIsElementInTree();

  @Test
  public abstract void findShouldReturnFalseWhenNoElementInTree();

  @Test
  public abstract void removeShouldReturnTrueWhenElementRemoved();

  @Test
  public abstract void removeShouldReturnFalseWhenNoElementInTree();

  @Test
  public abstract void removeShouldReturnTrueWhenRemovingRoot();

  @Test
  public abstract void printInorderShouldReturnList();

  @Test
  public abstract void printPreOrderShouldReturnList();

  @Test
  public abstract void printPostOrderShouldReturnList();
}
