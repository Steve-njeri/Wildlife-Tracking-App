package models;

import org.sql2o.Connection;
import java.security.Timestamp;
import org.sql2o.Sql2oException;
import java.util.List;
import java.util.Objects;

public class Sighting {
    private int animal_id;
    private String location;
    public String rangerName;
    private  Timestamp lastSeen;
    private int id;

    public Sighting(int animal_id, String location, String rangerName)  {
        this.animal_id = animal_id;
        this.location = location;
        this.rangerName = rangerName;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public Timestamp getLastSeen() {
        return lastSeen;
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
        if (this == otherSighting) return true;
        if (otherSighting == null || getClass() != otherSighting.getClass()) return false;
            Sighting sighting =(Sighting) otherSighting;
            return id == sighting.id &&
                    animal_id == sighting.animal_id &&
                    Objects.equals(rangerName, sighting.rangerName) &&
                    Objects.equals(lastSeen, sighting.lastSeen) &&
                    Objects.equals(location, sighting.location);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rangerName, lastSeen, animal_id, location);
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
            String sql = "INSERT INTO sightings (animal_id, location, rangerName, lastSeen) VALUES (:animal_id, :location, :rangerName, now());";
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
