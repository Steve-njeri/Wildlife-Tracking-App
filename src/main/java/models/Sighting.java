package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import java.util.List;
import java.util.Objects;

public class Sighting {
    private int animal_id;
    private String location;
    public String rangerName;
    private int id;

    public Sighting(int animal_id, String location, String rangerName)  {
        this.animal_id = animal_id;
        this.location = location;
        this.rangerName = rangerName;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getId(){
        return id;
    }


    @Override
    public boolean equals(Object otherSighting) {
        if (!(otherSighting instanceof Sighting )) {
            return false;
        } else {
            Sighting newSighting = (Sighting) otherSighting;
            return this.getAnimal_id() == (newSighting.getAnimal_id()) &&
                    this.getRangerName().equals(newSighting.getRangerName()) &&
                    this.getLocation().equals(newSighting.getLocation());
        }
    }


    public static List<Sighting> getAll() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings;";
            return con.createQuery(sql)
                    .executeAndFetch(Sighting.class);
        }
    }


    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animal_id, location, rangerName) VALUES (:animal_id, :location, :rangerName);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animal_id", this.animal_id)
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
                    .executeUpdate()
                    .getKey();
        }catch (Sql2oException err){
            System.out.println("error::: "+ err);
        }
    }

    public static Sighting findById(int id){
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
        }
    }

    public static void clearAll(){
        try(Connection connection= DB.sql2o.open()){
            String sql ="DELETE FROM sightings *";
            connection.createQuery(sql).executeUpdate();
        }
    }

    public static void delete(int id){
        try(Connection connection= DB.sql2o.open()){
            String sql = "DELETE FROM sightings  WHERE id = :id;";
            connection.createQuery(sql).addParameter("id",id).executeUpdate();
        } catch(Sql2oException err){
            System.out.println("error::: "+ err);
        }
    }
}
