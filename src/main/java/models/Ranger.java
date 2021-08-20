package models;

import org.sql2o.Connection;

import java.util.List;

public class Ranger {
    private int id;
    private String name;
    private int badge_number;

    public Ranger(String name, int badge_number) {
        this.name = name;
        this.badge_number = badge_number;
    }

    public String getName() {
        return name;
    }

    public int getBadge_number() {
        return badge_number;
    }


    @Override
    public boolean equals(Object otherRanger){
        if (!(otherRanger instanceof EndangeredAnimal)) {
            return false;
        } else {
            Ranger newRanger = (Ranger) otherRanger;
            return this.getName().equals(newRanger.getName()) &&
                    this.getBadge_number() == (newRanger.getBadge_number());
        }
    }

    public static List<Ranger> all() {
        String sql = "SELECT * FROM rangers";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Ranger.class);
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO rangers (name, badge_number) VALUES (:name, :badge_number);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("badge_number", this.badge_number)
                    .executeUpdate()
                    .getKey();
        }
    }

    public int getId(){
        return id;
    }

    public static Ranger find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM rangers where id=:id";
            Ranger ranger = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranger.class);
            return ranger;
        }
    }
}
