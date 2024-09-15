package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

  GroceryCounter counter;

  @BeforeEach
  void setUp() {
    counter = new GroceryCounter();
  }

  @Test
  void testOriginalTotal(){
    assertEquals("$00.00", counter.total());
  }

  @Test
  void testIncrementHundredths() {
    counter.hundredths();
    assertEquals("$00.01", counter.total());
  }

  @Test
  void testIncrementTenths() {
    counter.tenths();
    assertEquals("$00.10", counter.total());
  }

  @Test
  void testIncrementOnes() {
    counter.ones();
    assertEquals("$01.00", counter.total());
  }

  @Test
  void testIncrementTens() {
    counter.tens();
    assertEquals("$10.00", counter.total());
  }

  @Test
  void testHundredthsOverflowToTenths() {
    for (int i = 0; i < 10; i++) {
        counter.hundredths();
    }
    assertEquals("$00.10", counter.total());
  }

  @Test
  void testTenthsOverflowToOnes() {
    for (int i = 0; i < 10; i++) {
      counter.tenths();
    }
    assertEquals("$01.00", counter.total());
  }

  @Test
  void testOnesOverflowToTens() {
    for (int i = 0; i < 10; i++) {
        counter.ones();
    }
    assertEquals("$10.00", counter.total());
  }

  @Test
  void testTensOverflow() {
    for (int i = 0; i < 10; i++) {
        counter.tens();
    }
    assertEquals("$00.00", counter.total());
    assertEquals(1, counter.number_of_overflows());
  }

  @Test
  void testClear() {
    counter.ones();
    counter.hundredths();
    counter.tenths();
    counter.tens();
    counter.clear();
    assertEquals("$00.00", counter.total());
    assertEquals(0, counter.number_of_overflows());
  }

  @Test
  void itWorks() {
    assertEquals(true, true);
  }

}
