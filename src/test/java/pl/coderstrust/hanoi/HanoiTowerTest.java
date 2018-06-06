package pl.coderstrust.hanoi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.hamcrest.CoreMatchers.is;

public class HanoiTowerTest {

  HanoiTower hanoiTower;
  Deque<Integer> towerA;
  Deque<Integer> towerB;
  Deque<Integer> towerC;

  @Before
  public void setup() {
    hanoiTower = new HanoiTower();
    towerA = new ArrayDeque<>();
    towerB = new ArrayDeque<>();
    towerC = new ArrayDeque<>();
  }

  @Test
  public void moveTowerUsingDeque() {
    Deque<Integer> expectedResult = new ArrayDeque<>();
    expectedResult.addLast(3);
    expectedResult.addLast(2);
    expectedResult.addLast(1);
    towerA.addLast(3);
    towerA.addLast(2);
    towerA.addLast(1);
    Deque<Integer> result = hanoiTower.moveTowerUsingDeque(3, towerA, towerB, towerC);
    Assert.assertArrayEquals(expectedResult.toArray(), result.toArray());
    Assert.assertThat(result.toArray(), is(expectedResult.toArray()));
  }
}
