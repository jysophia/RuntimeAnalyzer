public class TestProgramClass {
  int val;

  TestProgramClass(int i) {
    val = i;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public int returnTest() {
    if (val > 0) {
      return 5;
    } else {
      return 10;
    }
  }
}
