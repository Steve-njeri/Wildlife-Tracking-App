package models;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-18-211-41-246.compute-1.amazonaws.com:5432/d6orupu6ca4o8m","jmibawcyjunppq","ec574f4c92cdb80d235426b083836cb6f3bd1b8e9eef80395c6aa4a8d4dbc07e");
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracking", "stephen", "123456");
}
