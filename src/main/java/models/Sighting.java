package models;

import org.sql2o.Connection;

import java.util.List;

public class Sighting {
    private int animal_id;
    private String location;
    private String rangerName;
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

    @Override
    public boolean equals (Object otherSighting){
        if (!(otherSighting instanceof Sighting)){
            return false;
        }else{
            Sighting sighting =(Sighting) otherSighting;
            return this.getAnimal_id()==sighting.getAnimal_id() &&
                    this.getLocation().equals(sighting.getLocation()) &&
                    this.getRangerName().equals(sighting.getRangerName());
        }
    }

    public static List<Sighting> all() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings_;";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }


    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings_ (animal_id, location, rangerName) VALUES (:animal_id, :location, :rangerName)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animal_id", this.animal_id)
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }

    public int getId(){
        return id;
    }

    public static Sighting find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings_ WHERE id=:id;";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }
}
