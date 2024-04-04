import TelemetryTools.CallTelemetry;
import TelemetryTools.ReturnTelemetry;
import TelemetryTools.TelemetryLogger;

public class TestProgramClass {

    int val;

    TestProgramClass(int i) {
        val = i;
    }

    public int getVal() {
        int _objectId_ = this.hashCode();
        String _type_ = this.getClass().getName();
        String _methodName_ = ("getVal");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_);
        TelemetryLogger.logCall(_callTelemetry_);
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_);
        TelemetryLogger.logReturn(_returnTelemetry_);
        return val;
    }

    public void setVal(int val) {
        int _objectId_ = this.hashCode();
        String _type_ = this.getClass().getName();
        String _methodName_ = ("setVal");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_);
        TelemetryLogger.logCall(_callTelemetry_);
        this.val = val;
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_);
        TelemetryLogger.logReturn(_returnTelemetry_);
    }

    public int returnTest() {
        int _objectId_ = this.hashCode();
        String _type_ = this.getClass().getName();
        String _methodName_ = ("returnTest");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_);
        TelemetryLogger.logCall(_callTelemetry_);
        if (val > 0) {
            long _returnNanos_ = System.nanoTime();
            long _duration_ = _returnNanos_ - _callNanos_;
            ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_);
            TelemetryLogger.logReturn(_returnTelemetry_);
            return 5;
        } else {
            long _returnNanos_ = System.nanoTime();
            long _duration_ = _returnNanos_ - _callNanos_;
            ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_);
            TelemetryLogger.logReturn(_returnTelemetry_);
            return 10;
        }
    }
}
