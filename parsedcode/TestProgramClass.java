import TelemetryTools.CallTelemetry;
import TelemetryTools.ReturnTelemetry;
import TelemetryTools.TelemetryLogger;

public class TestProgramClass {

    int val;

    TestProgramClass(int i) {
        val = i;
    }

    public int getVal() {
        int objectId = this.hashCode();
        String type = this.getClass().getName();
        String methodName = ("getVal");
        long callNanos = System.nanoTime();
        CallTelemetry callTelemetry = new CallTelemetry(objectId, methodName, type, callNanos);
        TelemetryLogger.logCall(callTelemetry);
        long returnNanos = System.nanoTime();
        long duration = returnNanos - callNanos;
        ReturnTelemetry returnTelemetry = new ReturnTelemetry(objectId, methodName, type, returnNanos, duration);
        TelemetryLogger.logReturn(returnTelemetry);
        return val;
    }

    public void setVal(int val) {
        int objectId = this.hashCode();
        String type = this.getClass().getName();
        String methodName = ("setVal");
        long callNanos = System.nanoTime();
        CallTelemetry callTelemetry = new CallTelemetry(objectId, methodName, type, callNanos);
        TelemetryLogger.logCall(callTelemetry);
        this.val = val;
        long returnNanos = System.nanoTime();
        long duration = returnNanos - callNanos;
        ReturnTelemetry returnTelemetry = new ReturnTelemetry(objectId, methodName, type, returnNanos, duration);
        TelemetryLogger.logReturn(returnTelemetry);
    }

    public int returnTest() {
        int objectId = this.hashCode();
        String type = this.getClass().getName();
        String methodName = ("returnTest");
        long callNanos = System.nanoTime();
        CallTelemetry callTelemetry = new CallTelemetry(objectId, methodName, type, callNanos);
        TelemetryLogger.logCall(callTelemetry);
        if (val > 0) {
            long returnNanos = System.nanoTime();
            long duration = returnNanos - callNanos;
            ReturnTelemetry returnTelemetry = new ReturnTelemetry(objectId, methodName, type, returnNanos, duration);
            TelemetryLogger.logReturn(returnTelemetry);
            return 5;
        } else {
            long returnNanos = System.nanoTime();
            long duration = returnNanos - callNanos;
            ReturnTelemetry returnTelemetry = new ReturnTelemetry(objectId, methodName, type, returnNanos, duration);
            TelemetryLogger.logReturn(returnTelemetry);
            return 10;
        }
    }
}
