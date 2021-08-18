package models;

public interface DatabaseManagement {
    boolean equals(Object otherObject);
    void save();
    void update(String name);
    void delete();

}
