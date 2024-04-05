import TestProgramPackage.AnotherTestClass;
public class Main {
  public static void main(String[] args) {
    TestProgramClass tc = new TestProgramClass(0);
    AnotherTestClass atc = new AnotherTestClass();

    try {
      Thread.sleep(800);
    } catch (Exception e) {
    }

    printSomething(tc, 12);

    try {
      Thread.sleep(800);
    } catch (Exception e) {
    }

//    exponentiallyIncreaseValue(tc, 5);
//    divideUntilFraction(tc);
  }

  public static void printSomething(TestProgramClass tpc, int val) {
    System.out.println("The old value of the TestProgramClass is " + tpc.getVal());

    try {
      Thread.sleep(800);
    } catch (Exception e) {
    }

    tpc.returnTest();

    try {
      Thread.sleep(400);
    } catch (Exception e) {
    }

    if (val > 10) {
      tpc.setVal(val);

      try {
        Thread.sleep(200);
      } catch (Exception e) {
      }

      tpc.returnTest();

      try {
        Thread.sleep(400);
      } catch (Exception e) {
      }

      printSomething(tpc, val - 5);
    }

    try {
      Thread.sleep(200);
    } catch (Exception e) {
    }

    System.out.println("The new value of the TestProgramClass is " + tpc.getVal());
  }

  public static void exponentiallyIncreaseValue(TestProgramClass tpc, int val) {
    for (int i = 0; i < val; i++) {
      tpc.val = tpc.val * tpc.val;
    }
    System.out.println("The new value of the TestProgramClass is " + tpc.getVal());
  }

  public static void divideUntilFraction(TestProgramClass tpc) {
    tpc.val = tpc.val / 2;

    while (tpc.val > 0) {
      divideUntilFraction(tpc);
    }

    System.out.println("The new value of the TestProgramClass is " + tpc.getVal());
  }
}