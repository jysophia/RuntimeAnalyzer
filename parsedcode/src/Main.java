import TestProgramPackage.AnotherTestClass;
import TelemetryTools.CallTelemetry;
import TelemetryTools.ReturnTelemetry;
import TelemetryTools.TelemetryLogger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> _paramTypes_ = new ArrayList<>();
        List<String> _paramNames_ = new ArrayList<>();
        List<String> _paramVals_ = new ArrayList<>();
        _paramTypes_.add("String[]");
        _paramNames_.add("args");
        _paramVals_.add("NonPrimativeType");
        int _objectId_ = 0;
        String _type_ = "static";
        String _methodName_ = ("main");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_, _paramTypes_, _paramNames_, _paramVals_);
        TelemetryLogger.logCall(_callTelemetry_);
        TestProgramClass tc = new TestProgramClass(0);
        AnotherTestClass atc = new AnotherTestClass();
        printSomething(tc, 15);
        exponentiallyIncreaseValue(tc, 5);
        divideUntilFraction(tc);
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_);
        TelemetryLogger.logReturn(_returnTelemetry_);
        TelemetryLogger.dumpLogs();
    }

    public static void printSomething(TestProgramClass tpc, int val) {
        List<String> _paramTypes_ = new ArrayList<>();
        List<String> _paramNames_ = new ArrayList<>();
        List<String> _paramVals_ = new ArrayList<>();
        _paramTypes_.add("TestProgramClass");
        _paramNames_.add("tpc");
        _paramVals_.add("NonPrimativeType");
        _paramTypes_.add("int");
        _paramNames_.add("val");
        _paramVals_.add(String.valueOf(val));
        int _objectId_ = 0;
        String _type_ = "static";
        String _methodName_ = ("printSomething");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_, _paramTypes_, _paramNames_, _paramVals_);
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

    public static void exponentiallyIncreaseValue(TestProgramClass tpc, int val) {
        List<String> _paramTypes_ = new ArrayList<>();
        List<String> _paramNames_ = new ArrayList<>();
        List<String> _paramVals_ = new ArrayList<>();
        _paramTypes_.add("TestProgramClass");
        _paramNames_.add("tpc");
        _paramVals_.add("NonPrimativeType");
        _paramTypes_.add("int");
        _paramNames_.add("val");
        _paramVals_.add(String.valueOf(val));
        int _objectId_ = 0;
        String _type_ = "static";
        String _methodName_ = ("exponentiallyIncreaseValue");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_, _paramTypes_, _paramNames_, _paramVals_);
        TelemetryLogger.logCall(_callTelemetry_);
        for (int i = 0; i < val; i++) {
            tpc.val = tpc.val * tpc.val;
        }
        System.out.println("The new value of the TestProgramClass is " + tpc.getVal());
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_);
        TelemetryLogger.logReturn(_returnTelemetry_);
    }

    public static void divideUntilFraction(TestProgramClass tpc) {
        List<String> _paramTypes_ = new ArrayList<>();
        List<String> _paramNames_ = new ArrayList<>();
        List<String> _paramVals_ = new ArrayList<>();
        _paramTypes_.add("TestProgramClass");
        _paramNames_.add("tpc");
        _paramVals_.add("NonPrimativeType");
        int _objectId_ = 0;
        String _type_ = "static";
        String _methodName_ = ("divideUntilFraction");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_, _paramTypes_, _paramNames_, _paramVals_);
        TelemetryLogger.logCall(_callTelemetry_);
        tpc.val = tpc.val / 2;
        while (tpc.val > 0) {
            divideUntilFraction(tpc);
        }
        System.out.println("The new value of the TestProgramClass is " + tpc.getVal());
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_);
        TelemetryLogger.logReturn(_returnTelemetry_);
    }
}
