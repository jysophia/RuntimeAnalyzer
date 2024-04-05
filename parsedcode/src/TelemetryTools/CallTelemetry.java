package TelemetryTools;

import org.json.simple.JSONObject;

import java.util.List;

public class CallTelemetry {
  private final int objectId;
  private final String methodName;
  private final String type;
  private final long callNanos;
  private final List<String> paramTypes;
  private final List<String> paramNames;
  private final List<String> paramVals;

  public CallTelemetry(int objectId, String methodName, String type, long callNanos, List<String> paramTypes,
                       List<String> paramNames, List<String> paramVals) {
    this.objectId = objectId;
    this.methodName = methodName;
    this.type = type;
    this.callNanos = callNanos;
    this.paramTypes = paramTypes;
    this.paramNames = paramNames;
    this.paramVals = paramVals;
  }

  public JSONObject toJson() {
    JSONObject ctJson = new JSONObject();
    ctJson.put("objectId", objectId);
    ctJson.put("methodName", methodName);
    ctJson.put("type", type);
    ctJson.put("callNanos", callNanos);
    ctJson.put("paramTypes", paramTypes);
    ctJson.put("paramNames", paramNames);
    ctJson.put("paramVals", paramVals);
    return ctJson;
  }
}