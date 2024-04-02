function outerFunc() {
  func1(3);
  func2();
  func3();
}

function func1(num) {
  if (num === 0) {
    return 0;
  } else {
    func1(num - 1);
  }
}

function func2() {
  func3();
}

function func3() {
  // nothing
}
