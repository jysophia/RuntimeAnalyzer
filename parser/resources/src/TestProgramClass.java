public class TestProgramClass {
  int val;

  TestProgramClass(int i) {
    val = i;
  }

  public int getVal() {
    try {
      Thread.sleep(800);
    } catch (Exception e) {
    }
    return val;
  }

  public void setVal(int val) {
    try {
      Thread.sleep(600);
    } catch (Exception e) {
    }
    this.val = val;
  }

  public int returnTest() {
    try {
      Thread.sleep(400);
    } catch (Exception e) {
    }
    if (val > 0) {
      return 5;
    } else {
      return 10;
    }
  }
}
