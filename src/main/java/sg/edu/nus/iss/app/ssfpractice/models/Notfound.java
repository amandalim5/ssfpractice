package sg.edu.nus.iss.app.ssfpractice.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Notfound {
  public JsonObject toJSON(String id) {
    return Json.createObjectBuilder()
            .add("message", "Order " + id + " not found")
            .build();
  }
}
