import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
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
            System.out.println(name);
            animal.save();
            response.redirect("/animals");
            return null;
        });

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
            model.put("sightings", sighting);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //retrieving all sightings
        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("sightings", Sighting.getAll());
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //retrieving rangers form
        get("rangers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "ranger-form.hbs");
        }, new HandlebarsTemplateEngine());

        //posting a ranger form details
        post("/rangers", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int badge_number=Integer.parseInt(request.queryParams("badge_number"));
            Ranger ranger = new Ranger(name, badge_number);
            System.out.println(name);
            System.out.println(badge_number);
            ranger.save();
            model.put("rangers", Ranger.all());
            return new ModelAndView(model, "rangers.hbs");
        }, new HandlebarsTemplateEngine());

        //retrieving all rangers
        get("/rangers", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("rangers", Ranger.all());
            return new ModelAndView(model, "rangers.hbs");
        }, new HandlebarsTemplateEngine());

        //retrieving new location form
        get("locations/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "location-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/locations", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Location location = new Location(name);
            location.save();
            model.put("locations", Location.all());
            return new ModelAndView(model, "locations.hbs");
        }, new HandlebarsTemplateEngine());

        get("/locations", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("locations", Location.all());
            return new ModelAndView(model, "locations.hbs");
        }, new HandlebarsTemplateEngine());

        post("/locations/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Location location = Location.find(Integer.parseInt(request.params(":id")));
            location.delete();
            model.put("locations", Location.all());
            return new ModelAndView(model,"locations.hbs");
        }, new HandlebarsTemplateEngine());

        get("endangered/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("animals", Animal.ANIMAL_TYPE);
            return new ModelAndView(model,"endangered-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            EndangeredAnimal eAnimal = new EndangeredAnimal(name,health,age);
            eAnimal.save();
            model.put("endangered", EndangeredAnimal.all());
            return new ModelAndView(model, "endangered.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("endangered", EndangeredAnimal.all());
            return new ModelAndView(model, "endangered.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
