package TelemetryTools;

import org.json.simple.JSONObject;

import java.util.List;

public class CallTelemetry {
  private final int objectId;
  private final String methodName;
  private final String type;
  private final long callNanos;

  public CallTelemetry(int objectId, String methodName, String type, long callNanos) {
    this.objectId = objectId;
    this.methodName = methodName;
    this.type = type;
    this.callNanos = callNanos;
  }

  public JSONObject toJson() {
    JSONObject ctJson = new JSONObject();
    ctJson.put("objectId", objectId);
    ctJson.put("methodName", methodName);
    ctJson.put("type", type);
    ctJson.put("callNanos", callNanos);
    return ctJson;
  }
}