package pl.coderstrust.hanoi;

import java.util.ArrayDeque;
import java.util.Deque;

public class HanoiTower {

  private static final int HEIGHT = 3;

  public static void main(String[] args) {

    Deque<Integer> towerA = creteTower(HEIGHT);
    Deque<Integer> towerB = creteTower(0);
    Deque<Integer> towerC = creteTower(0);
    moveTowerUsingDeque(HEIGHT, towerA, towerC, towerB);

    char sourceTower = 'A';
    char middleTower = 'B';
    char targetTower = 'C';
    moveTower(HEIGHT, sourceTower, targetTower, middleTower);
  }

  public static void moveTower(int height, char source, char target, char middle) {
    if (height > 0) {
      moveTower(height - 1, source, middle, target);
      System.out.println(
          "Moving disk " + height + " from tower " + source + " to tower " + target + ".");
      moveTower(height - 1, middle, target, source);
    }
  }

  public static Deque<Integer> moveTowerUsingDeque(
      int height, Deque<Integer> source, Deque<Integer> target, Deque<Integer> middle) {
    if (height > 0) {
      moveTowerUsingDeque(height - 1, source, middle, target);
      moveDisk(height, source, target);
      moveTowerUsingDeque(height - 1, middle, target, source);
    }
    return target;
  }

  public static Deque<Integer> moveDisk(int disk, Deque<Integer> source, Deque<Integer> target) {
    System.out.println(
        "Moving disk " + disk + " from tower " + source + " to tower " + target + ".");
    source.removeLast();
    target.addLast(disk);
    return target;
  }

  public static Deque<Integer> creteTower(int height) {
    Deque<Integer> tower = new ArrayDeque<>();
    for (int i = height; i > 0; i--) {
      tower.addLast(i);
    }
    return tower;
  }
}
