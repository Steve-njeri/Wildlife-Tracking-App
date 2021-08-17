package models;

import org.sql2o.Connection;

import java.util.List;

public class Location {
    private int id;
    private String name;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherLocation){
        if (!(otherLocation instanceof Location)) {
            return false;
        } else {
            Location location = (Location) otherLocation;
            return this.getName().equals(location.getName());
        }
    }

    public static List<Location> all(){
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM locations")
                    .executeAndFetch(Location.class);
        }
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO locations (name) VALUES(:name)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public int getId() {
        return id;
    }

    public static Location find(int id){
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM locations WHERE id=:id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Location.class);
        }
    }
}
