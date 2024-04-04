import TestProgramPackage.AnotherTestClass;
import TelemetryTools.CallTelemetry;
import TelemetryTools.ReturnTelemetry;
import TelemetryTools.TelemetryLogger;
import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String[] args) {
        TestProgramClass tc = new TestProgramClass(0);
        AnotherTestClass anotherTestClass = new AnotherTestClass();
        printSomething(tc, 15);
        TelemetryLogger.dumpLogs();
    }

    public static void printSomething(TestProgramClass tpc, int val) {
        int objectId = 0;
        String type = "static";
        String methodName = ("printSomething");
        long callNanos = System.nanoTime();
        CallTelemetry callTelemetry = new CallTelemetry(objectId, methodName, type, callNanos);
        TelemetryLogger.logCall(callTelemetry);
        System.out.println("The old value of the TestProgramClass is " + tpc.getVal());
        tpc.returnTest();
        tpc.setVal(val);
        tpc.returnTest();
        System.out.println("The new value of the TestProgramClass is " + tpc.getVal());
        long returnNanos = System.nanoTime();
        long duration = returnNanos - callNanos;
        ReturnTelemetry returnTelemetry = new ReturnTelemetry(objectId, methodName, type, returnNanos, duration);
        TelemetryLogger.logReturn(returnTelemetry);
    }
}
