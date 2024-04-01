public class Main {
  public static void main(String[] args) {
    TestProgramClass tc = new TestProgramClass(5);
    AnotherTestClass anotherTestClass = new AnotherTestClass();
    printSomething(tc, 15);
  }

  public static void printSomething(TestProgramClass tpc, int val) {
    System.out.println("The old value of the TestProgramClass is " + tpc.getVal());
    tpc.setVal(val);
    System.out.println("The new value of the TestProgramClass is " + tpc.getVal());
  }
}