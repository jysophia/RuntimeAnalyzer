import TelemetryTools.CallTelemetry;
import TelemetryTools.ReturnTelemetry;
import TelemetryTools.TelemetryLogger;
import java.util.*;

public class TestProgramClass {

    int val;

    TestProgramClass(int i) {
        val = i;
    }

    public int getVal() {
        List<String> _paramTypes_ = new ArrayList<>();
        List<String> _paramNames_ = new ArrayList<>();
        List<String> _paramVals_ = new ArrayList<>();
        int _objectId_ = this.hashCode();
        String _type_ = this.getClass().getName();
        String _methodName_ = ("getVal");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_, _paramTypes_, _paramNames_, _paramVals_);
        TelemetryLogger.logCall(_callTelemetry_);
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_);
        TelemetryLogger.logReturn(_returnTelemetry_);
        return val;
    }

    public void setVal(int val) {
        List<String> _paramTypes_ = new ArrayList<>();
        List<String> _paramNames_ = new ArrayList<>();
        List<String> _paramVals_ = new ArrayList<>();
        _paramTypes_.add("int");
        _paramNames_.add("val");
        _paramVals_.add(String.valueOf(val));
        int _objectId_ = this.hashCode();
        String _type_ = this.getClass().getName();
        String _methodName_ = ("setVal");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_, _paramTypes_, _paramNames_, _paramVals_);
        TelemetryLogger.logCall(_callTelemetry_);
        this.val = val;
        long _returnNanos_ = System.nanoTime();
        long _duration_ = _returnNanos_ - _callNanos_;
        ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_);
        TelemetryLogger.logReturn(_returnTelemetry_);
    }

    public int returnTest() {
        List<String> _paramTypes_ = new ArrayList<>();
        List<String> _paramNames_ = new ArrayList<>();
        List<String> _paramVals_ = new ArrayList<>();
        int _objectId_ = this.hashCode();
        String _type_ = this.getClass().getName();
        String _methodName_ = ("returnTest");
        long _callNanos_ = System.nanoTime();
        CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, _methodName_, _type_, _callNanos_, _paramTypes_, _paramNames_, _paramVals_);
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
