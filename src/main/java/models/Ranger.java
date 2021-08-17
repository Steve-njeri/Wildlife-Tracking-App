package models;

import org.sql2o.Connection;

import java.util.List;

public class Ranger {
    private int id;
    private String name;
    private int badge_number;
    private int phone_number;
    private String email;

    public Ranger(String name, int badge_number, int phone_number, String email) {
        this.name = name;
        this.badge_number = badge_number;
        this. phone_number = phone_number;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public int getBadge_number() {
        return badge_number;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object otherRanger){
        if (!(otherRanger instanceof Ranger)) {
            return false;
        } else {
            Ranger newRanger = (Ranger) otherRanger;
            return this.getName().equals(newRanger.getName()) &&
                    this.getBadge_number() == newRanger.getBadge_number() &&
                    this.getPhone_number() == newRanger.getPhone_number() &&
                    this.getEmail().equals(newRanger.getEmail());

        }
    }

    public static List<Ranger> all(){
        try(Connection con = DB.sql2o.open()){
            return  con.createQuery("SELECT * FROM  rangers")
                    .executeAndFetch(Ranger.class);
        }
    }

    public void save(){
        try (Connection conn = DB.sql2o.open()){
            String sql = "INSERT INTO rangers (name,badge_number,phone_number,email) VALUES(:name, :badge_number :phone_number :email)";
            this.id = (int) conn.createQuery(sql,true)
                    .addParameter("name",name)
                    .addParameter("badge_number",this.badge_number)
                    .addParameter("phone_number",this.phone_number)
                    .addParameter("email",this.email)
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
