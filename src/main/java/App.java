import models.Animal;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //retrieving new animal form
        get("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        // posting animals form details
        post("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Animal animal = new Animal(name);
            animal.save();
            model.put("animals", Animal.all());
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //retrieving all animals
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("animals", Animal.all());
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
