import models.*;
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
            model.put("animals", Animal.ANIMAL_TYPE);
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

        //deleting animal object
        get("/animals/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Animal animal = Animal.find(Integer.parseInt(request.params(":id")));
            animal.delete();
            model.put("animals", Animal.all());
            return new ModelAndView(model,"animals.hbs");
        }, new HandlebarsTemplateEngine());

        //retrieving sighting form
        get("sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("animals", Animal.all());
            model.put("locations", Location.all());
            model.put("endangeredAnimals", EndangeredAnimal.all());
            model.put("rangers", Ranger.all());
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //posting a sighting form details
        post("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int animal_id = Integer.parseInt(request.queryParams("animal_id"));
            String rangerName = request.queryParams("rangerName");
            String location = request.queryParams("location");
            Sighting sighting = new Sighting(animal_id,rangerName,location);
            sighting.save();
            model.put("sightings", Sighting.all());
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //retrieving all sightings
        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("sightings", Sighting.all());
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("rangers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "ranger-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/rangers", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int badge_number=Integer.parseInt(request.queryParams("badge_number"));
            int phone_number=Integer.parseInt(request.queryParams("phone_number"));
            String email=request.queryParams("email");
            Ranger ranger = new Ranger(name, badge_number, phone_number, email);
            ranger.save();
            model.put("rangers", Ranger.all());
            return new ModelAndView(model, "rangers.hbs");
        }, new HandlebarsTemplateEngine());

        get("/rangers", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("rangers", Ranger.all());
            return new ModelAndView(model, "rangers.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
