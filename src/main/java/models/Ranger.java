package models;

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
}
