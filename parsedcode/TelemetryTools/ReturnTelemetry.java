package TelemetryTools;

import org.json.simple.JSONObject;

public class ReturnTelemetry {
  private final int objectId;
  private final String methodName;
  private final String type;
  private final long returnNanos;
  private final long duration;

  public ReturnTelemetry(int objectId, String methodName, String type, long returnNanos, long duration) {
    this.objectId = objectId;
    this.methodName = methodName;
    this.type = type;
    this.returnNanos = returnNanos;
    this.duration = duration;
  }

  public JSONObject toJson() {
    JSONObject rtJson = new JSONObject();
    rtJson.put("objectId", objectId);
    rtJson.put("methodName", methodName);
    rtJson.put("type", type);
    rtJson.put("returnNanos", returnNanos);
    rtJson.put("duration", duration);
    return rtJson;
  }
}