import TestProgramPackage.AnotherTestClass;
public class Main {
  public static void main(String[] args) {
    TestProgramClass tc = new TestProgramClass(0);
    AnotherTestClass atc = new AnotherTestClass();
    printSomething(tc, 15);
    exponentiallyIncreaseValue(tc, 5);
    divideUntilFraction(tc);
  }

  public static void printSomething(TestProgramClass tpc, int val) {
    System.out.println("The old value of the TestProgramClass is " + tpc.getVal());
    tpc.returnTest();
    tpc.setVal(val);
    tpc.returnTest();
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