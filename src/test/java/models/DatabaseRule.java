package models;

import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracking", "stephen", "123456");  //Those with linux or windows use two strings for username and password
    }

    @Override
    protected void after() {
        try (Connection con = DB.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            String deleteEndangered_animalsQuery = "DELETE FROM endangered_animals *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            String deleteRangersQuery = "DELETE FROM rangers *;";
            String deleteLocationsQuery = "DELETE FROM locations *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteEndangered_animalsQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
            con.createQuery(deleteRangersQuery).executeUpdate();
            con.createQuery(deleteLocationsQuery).executeUpdate();
        }
    }
}

