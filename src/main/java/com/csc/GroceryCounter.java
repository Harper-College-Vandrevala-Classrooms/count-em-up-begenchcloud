package com.csc;

public class GroceryCounter {


  int tens;
  int ones;
  int tenths;
  int hundredths;
  int overflows;

  public GroceryCounter() {
    tens = 0;
    ones = 0;
    tenths = 0;
    hundredths = 0;
    overflows = 0;
  }

  public void tens() {
    tens++;
      if (tens > 9) {
        tens = 0;
        overflowCheck();
    }
  }

  public void ones() {
    ones++;
    if (ones > 9) {
      ones = 0;
      tens();
    }
  }

  public void tenths() {
    tenths++;
    if (tenths > 9) {
      tenths = 0;
      ones();
    }
  }

  public void hundredths() {
    hundredths++;
    if (hundredths > 9) {
      hundredths = 0;
      tenths();
    }
  }

  public void overflowCheck() {
    if (tens == 0 && ones == 0 && tenths == 0 && hundredths == 0) {
      overflows++;
    }
  }

  public String total() {
    return String.format("$%d%d.%d%d", tens, ones, tenths, hundredths);
  }

  public int number_of_overflows() {
    return overflows;
  }

  public void clear() {
    tens = 0;
    ones = 0;
    tenths = 0;
    hundredths = 0;
    overflows = 0;
  }

  public static void main(String[] args) {
    GroceryCounter counter = new GroceryCounter();

    System.out.println("Welcome to the Grocery Counter App!!!");

    System.out.println("Your total is: " + counter.total()); // This would print out $0.00

    counter.tens();
    counter.tens();
    counter.hundredths();

    System.out.println("Your total is: " + counter.total()); // This would print out $20.01
    System.out.println("Number of overflows: " + counter.number_of_overflows()); // This would print out 0

    for (int i = 0; i < 35; i++) {
      counter.ones();
    }

    System.out.println("Your total is: " + counter.total()); // This would print out $55.01
    System.out.println("Number of overflows: " + counter.number_of_overflows()); // This would print out 0

    for (int i = 0; i < 10001; i++) {
      counter.hundredths();
    }

    System.out.println("Your total is: " + counter.total()); // This would print out $55.02
    System.out.println("Number of overflows: " + counter.number_of_overflows()); // This should now print 1

    counter.clear();

    System.out.println("Your total is: " + counter.total()); // This would print out $0.00
    System.out.println("Number of overflows: " + counter.number_of_overflows()); // This would print out 0
  }
}
