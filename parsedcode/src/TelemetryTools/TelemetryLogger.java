package TelemetryTools;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TelemetryLogger {
  private static final Queue<CallTelemetry> calls = new LinkedList<>();
  private static final Queue<ReturnTelemetry> returns = new LinkedList<>();
  private static final List<String> mainParams = new ArrayList<>();

  public static void logMainParams(String[] params) {
    mainParams.addAll(Arrays.asList(params));
  }

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


    while (!calls.isEmpty()) {
      callsJson.add(calls.remove().toJson());
    }

    while (!returns.isEmpty()) {
      returnsJson.add(returns.remove().toJson());
    }

    log.put("mainParams", mainParams);
    log.put("calls", callsJson);
    log.put("returns", returnsJson);

    try {
      File logFile = new File("../log/log.json");
      FileWriter logWriter = new FileWriter(logFile);
      logWriter.write(log.toJSONString());
      logWriter.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}