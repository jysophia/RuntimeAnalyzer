import TestProgramPackage.AnotherTestClass;
import TelemetryTools.CallTelemetry;
import TelemetryTools.ReturnTelemetry;
import TelemetryTools.TelemetryLogger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int _objectId_ = 0;
        String _type_ = "static";
        String _methodName_ = ("main");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_);
        TelemetryLogger.logCall(_callTelemetry_);
        TestProgramClass tc = new TestProgramClass(0);
        AnotherTestClass atc = new AnotherTestClass();
        try {
            Thread.sleep(800);
        } catch (Exception e) {
        }
        printSomething(tc, 9);
        try {
            Thread.sleep(800);
        } catch (Exception e) {
        }
        List<String> _paramTypes_ = new ArrayList<>();
        List<String> _paramNames_ = new ArrayList<>();
        List<String> _paramVals_ = new ArrayList<>();
        _paramTypes_.add("String[]");
        _paramNames_.add("args");
        _paramVals_.add("NonPrimitiveType");
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_, _paramTypes_, _paramNames_, _paramVals_);
        TelemetryLogger.logReturn(_returnTelemetry_);
        TelemetryLogger.logMainParams(args);
        TelemetryLogger.dumpLogs();
        //    exponentiallyIncreaseValue(tc, 5);
        //    divideUntilFraction(tc);
    }

    public static void printSomething(TestProgramClass tpc, int val) {
        int _objectId_ = 0;
        String _type_ = "static";
        String _methodName_ = ("printSomething");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_);
        TelemetryLogger.logCall(_callTelemetry_);
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
        List<String> _paramTypes_ = new ArrayList<>();
        List<String> _paramNames_ = new ArrayList<>();
        List<String> _paramVals_ = new ArrayList<>();
        _paramTypes_.add("TestProgramClass");
        _paramNames_.add("tpc");
        _paramVals_.add("NonPrimitiveType");
        _paramTypes_.add("int");
        _paramNames_.add("val");
        _paramVals_.add(String.valueOf(val));
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_, _paramTypes_, _paramNames_, _paramVals_);
        TelemetryLogger.logReturn(_returnTelemetry_);
    }

    public static void exponentiallyIncreaseValue(TestProgramClass tpc, int val) {
        int _objectId_ = 0;
        String _type_ = "static";
        String _methodName_ = ("exponentiallyIncreaseValue");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_);
        TelemetryLogger.logCall(_callTelemetry_);
        for (int i = 0; i < val; i++) {
            tpc.val = tpc.val * tpc.val;
        }
        System.out.println("The new value of the TestProgramClass is " + tpc.getVal());
        List<String> _paramTypes_ = new ArrayList<>();
        List<String> _paramNames_ = new ArrayList<>();
        List<String> _paramVals_ = new ArrayList<>();
        _paramTypes_.add("TestProgramClass");
        _paramNames_.add("tpc");
        _paramVals_.add("NonPrimitiveType");
        _paramTypes_.add("int");
        _paramNames_.add("val");
        _paramVals_.add(String.valueOf(val));
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_, _paramTypes_, _paramNames_, _paramVals_);
        TelemetryLogger.logReturn(_returnTelemetry_);
    }

    public static void divideUntilFraction(TestProgramClass tpc) {
        int _objectId_ = 0;
        String _type_ = "static";
        String _methodName_ = ("divideUntilFraction");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_);
        TelemetryLogger.logCall(_callTelemetry_);
        tpc.val = tpc.val / 2;
        while (tpc.val > 0) {
            divideUntilFraction(tpc);
        }
        System.out.println("The new value of the TestProgramClass is " + tpc.getVal());
        List<String> _paramTypes_ = new ArrayList<>();
        List<String> _paramNames_ = new ArrayList<>();
        List<String> _paramVals_ = new ArrayList<>();
        _paramTypes_.add("TestProgramClass");
        _paramNames_.add("tpc");
        _paramVals_.add("NonPrimitiveType");
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_, _paramTypes_, _paramNames_, _paramVals_);
        TelemetryLogger.logReturn(_returnTelemetry_);
    }
}
