package models;

import java.util.List;

public class Animal {
    private int id;
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public static List<Object> all() {
    }

    public void save() {
    }
}
