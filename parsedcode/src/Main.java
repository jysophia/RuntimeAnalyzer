import TestProgramPackage.AnotherTestClass;
import TelemetryTools.CallTelemetry;
import TelemetryTools.ReturnTelemetry;
import TelemetryTools.TelemetryLogger;

public class Main {

    public static void main(String[] args) {
        int _objectId_ = 0;
        String _type_ = "static";
        String _methodName_ = ("main");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_);
        TelemetryLogger.logCall(_callTelemetry_);
        TestProgramClass tc = new TestProgramClass(0);
        AnotherTestClass anotherTestClass = new AnotherTestClass();
        printSomething(tc, 15);
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_);
        TelemetryLogger.logReturn(_returnTelemetry_);
        TelemetryLogger.dumpLogs();
    }

    public static void printSomething(TestProgramClass tpc, int val) {
        int _objectId_ = 0;
        String _type_ = "static";
        String _methodName_ = ("printSomething");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_);
        TelemetryLogger.logCall(_callTelemetry_);
        System.out.println("The old value of the TestProgramClass is " + tpc.getVal());
        tpc.returnTest();
        tpc.setVal(val);
        tpc.returnTest();
        System.out.println("The new value of the TestProgramClass is " + tpc.getVal());
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_);
        TelemetryLogger.logReturn(_returnTelemetry_);
    }
}
