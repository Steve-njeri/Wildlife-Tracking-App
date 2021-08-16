package models;

public class EndangeredAnimal {
    private String name;
    private String health;
    private String age;

    public EndangeredAnimal(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    @Override
    public boolean equals(Object otherEndangeredAnimal){
        if (!(otherEndangeredAnimal instanceof EndangeredAnimal)) {
            return false;
        } else {
            EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal) otherEndangeredAnimal;
            return this.getName().equals(newEndangeredAnimal.getName()) &&
                    this.getHealth().equals(newEndangeredAnimal.getHealth()) &&
                    this.getAge().equals(newEndangeredAnimal.getAge());
        }
    }
}
