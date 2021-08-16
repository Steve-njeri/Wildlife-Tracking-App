package models;

public class Ranger {
    private int id;
    private String name;
    private int badge_number;
    private int phone_number;
    private String email;

    public Ranger(String name, int tag_number, int mobile_number, String email) {
        this.name = name;
        this.badge_number = tag_number;
        this.phone_number = mobile_number;
        this.email = email;
    }
}
