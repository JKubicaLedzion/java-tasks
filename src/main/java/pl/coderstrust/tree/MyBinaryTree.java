package pl.coderstrust.tree;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree<E extends Comparable<E>> {

  private Node root;

  public boolean add(E value) {
    if (root == null) {
      root = new Node(value);
      return true;
    }
    return add(root, value) != null;
  }

  private Node add(Node node, E value) {
    if (node == null) {
      node = new Node(value);
      return node;
    }
    if (node.value.compareTo(value) < 0) {
      node.right = add(node.right, value);
      if (node.right == null) {
        return null;
      }
    } else if (node.value.compareTo(value) > 0) {
      node.left = add(node.left, value);
      if (node.left == null) {
        return null;
      }
    } else {
      node = null;
    }
    return node;
  }

  public boolean find(E value) {
    return find(root, value) != null;
  }

  private Node find(Node node, E value) {
    if (node == null || node.value == value) {
      return node;
    }
    if (node.value.compareTo(value) < 0) {
      return find(node.right, value);
    }
    return find(node.left, value);
  }

  public boolean remove(E value) {
    root = remove(root, value);
    return root != null;
  }

  private Node remove(Node node, E value) {
    if (node == null) {
      return null;
    }
    if (node.value.compareTo(value) < 0) {
      node.right = remove(node.right, value);
      if (node.right == null) {
        return null;
      }
    } else if (node.value.compareTo(value) > 0) {
      node.left = remove(node.left, value);
      if (node.left == null) {
        return null;
      }
    } else {
      if (node.right == null) {
        return node.left;
      }
      if (node.left == null) {
        return node.right;
      }
      Node temp = node;
      node = getSuccessor(node.right);
      node.right = remove(temp.right, (E) node.value);
      node.left = temp.left;
    }
    return node;
  }

  public List<E> printInorder() {
    return printInorder(root, null);
  }

  private List<E> printInorder(Node node, List<E> list) {
    list = getList(list);
    if (node == null) {
      return list;
    }
    printInorder(node.left, list);
    list.add((E) node.value);
    printInorder(node.right, list);
    return list;
  }

  public List<E> printPreOrder() {
    return printPreOrder(root, null);
  }

  private List<E> printPreOrder(Node node, List<E> list) {
    list = getList(list);
    if (node == null) {
      return list;
    }
    list.add((E) node.value);
    printPreOrder(node.left, list);
    printPreOrder(node.right, list);
    return list;
  }

  public List<E> printPostOrder() {
    return printPostOrder(root, null);
  }

  private List<E> printPostOrder(Node node, List<E> list) {
    list = getList(list);
    if (node == null) {
      return list;
    }
    printPostOrder(node.left, list);
    printPostOrder(node.right, list);
    list.add((E) node.value);
    return list;
  }

  private List<E> getList(List<E> list) {
    if (list == null) {
      list = new ArrayList<>();
    }
    return list;
  }

  private Node getSuccessor(Node node) {
    if (node.left != null) {
      return getSuccessor(node.left);
    }
    return node;
  }

  private static class Node<E extends Comparable<E>> {

    private E value;
    private Node<E> left;
    private Node<E> right;

    Node(E value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
}
