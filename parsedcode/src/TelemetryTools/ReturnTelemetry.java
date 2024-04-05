package TelemetryTools;

import org.json.simple.JSONObject;

import java.util.List;

public class ReturnTelemetry {
  private final int objectId;
  private final String methodName;
  private final String type;
  private final long returnNanos;
  private final long duration;

  private final List<String> paramTypes;
  private final List<String> paramNames;
  private final List<String> paramVals;

  public ReturnTelemetry(int objectId, String methodName, String type, long returnNanos, long duration, List<String> paramTypes,
                         List<String> paramNames, List<String> paramVals) {
    this.objectId = objectId;
    this.methodName = methodName;
    this.type = type;
    this.returnNanos = returnNanos;
    this.duration = duration;

    this.paramTypes = paramTypes;
    this.paramNames = paramNames;
    this.paramVals = paramVals;
  }

  public JSONObject toJson() {
    JSONObject rtJson = new JSONObject();
    rtJson.put("objectId", objectId);
    rtJson.put("methodName", methodName);
    rtJson.put("type", type);
    rtJson.put("returnNanos", returnNanos);
    rtJson.put("duration", duration);
    rtJson.put("paramTypes", paramTypes);
    rtJson.put("paramNames", paramNames);
    rtJson.put("paramVals", paramVals);
    return rtJson;
  }
}