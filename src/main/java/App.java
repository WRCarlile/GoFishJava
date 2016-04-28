// import java.util.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

    ProcessBuilder process = new ProcessBuilder();
         Integer port;
         if (process.environment().get("PORT") != null) {
             port = Integer.parseInt(process.environment().get("PORT"));
         } else {
             port = 4567;
         }

        setPort(port);

    staticFileLocation("/public");
      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/home.vtl");
        return new ModelAndView(model, "templates/layout.vtl");
      }, new VelocityTemplateEngine());

      post("/detector", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();


        Player newPlayer = new Player();
        Deck newDeck = new Deck();
        newDeck.shuffle();
        newDeck.dealHand(newPlayer);
        model.put("hand", newPlayer.getHand());

        model.put("template", "templates/detector.vtl");
        return new ModelAndView(model, "templates/layout.vtl");
      }, new VelocityTemplateEngine());
  }

  public static Boolean methodName(String userInput) {
    return true;
  }

}
