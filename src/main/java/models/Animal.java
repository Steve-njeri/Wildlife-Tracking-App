package models;

import org.sql2o.Connection;

import java.util.List;

public class Animal implements DatabaseManagement {
    private int id;
    private String name;
    public  String type;
    public static final String ANIMAL_TYPE = "animal";

    public Animal(String name) {
        this.name = name;
        this.type = ANIMAL_TYPE;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public static String getAnimalType() {
        return ANIMAL_TYPE;
    }

    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal animal = (Animal) otherAnimal;
            return this.getName().equals(animal.getName());
        }
    }

    public static List<Animal> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public void delete() {
        try (Connection conn = DB.sql2o.open()){
            String sql = "DELETE FROM animals WHERE id=:id;";
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }

    public int getId(){
        return id;
    }

    public static Animal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Animal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }

    @Override
    public void update(String name) {
        String sql = "UPDATE animals SET name=:name WHERE id=:id";
        try (Connection conn = DB.sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("name",name)
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


}
