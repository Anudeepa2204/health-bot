package healthbot.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
public class AlarmController {
  private static final Logger Log = LoggerFactory.getLogger(AlarmController.class);

  @PostMapping("alarm")
  public String addAlarm() {
    return "";
  }

  @GetMapping("ping")
  public String ping() {
    return "Pong";
  }

  @PostMapping("welcome")
  public String welcomeIntent(@RequestParam("data") String data) {
    Log.info("data from dialogflow: {}", data);
    String response = "";
    InputStream stream = AlarmController.class.getResourceAsStream("alarm-intent-generator.json");
    InputStreamReader reader = new InputStreamReader(stream);
    try {
      response = FileCopyUtils.copyToString(reader);
    } catch (IOException e) {
      Log.info(e.getMessage());
    }
    return response;
  }
}
