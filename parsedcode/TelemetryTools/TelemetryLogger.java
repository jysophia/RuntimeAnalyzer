package TelemetryTools;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TelemetryLogger {
  private static List<CallTelemetry> calls = new ArrayList<>();
  private static List<ReturnTelemetry> returns = new ArrayList<>();

  public static void logCall(CallTelemetry ct) {
    calls.add(ct);
  }

  public static void logReturn(ReturnTelemetry rt) {
    returns.add(rt);
  }

  public static void dumpLogs() {
    JSONObject log = new JSONObject();
    JSONArray callsJson = new JSONArray();
    JSONArray returnsJson = new JSONArray();

    calls.forEach(ct -> {
      callsJson.add(ct.toJson());
    });

    returns.forEach(rt -> {
      returnsJson.add(rt.toJson());
    });

    log.put("calls", callsJson);
    log.put("returns", returnsJson);

    Path logPath = FileSystems.getDefault().getPath("./log/log.json");
    try {
      Files.writeString(logPath, log.toJSONString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}