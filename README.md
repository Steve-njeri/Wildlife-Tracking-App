# Wildlife-tracker-project

## Author
STEPHEN NJERI

## Description
An application that allows Rangers to track wildlife sightings in the area

## Project Setup/Installation Requirements
* Make sure you installed java application

* install the following java requirements JUnit, intellij, SDK, JDK.

* git clone "https://github.com/Steve-njeri/Wildlife-Tracking-App.git
"
* Navigate into the hero-squad directory - cd Wildlife-tracker-project /Navigate into the src/main/java/App.java and click run in intellij.

* Go to your browser and type localhost:4567

## Database Setup
* To set up the database:

* Run psql in the project terminal.
* Type the command: CREATE DATABASE wildlife_tracker;
* Navigate into the database by typing the command: \c wildlife_tracking;
* Create the required tables by running the following commands:
* CREATE TABLE rangers (id serial PRIMARY KEY, name VARCHAR, badge_number INT,phone_number int,email VARCHAR);
* CREATE TABLE animals(id serial PRIMARY KEY,name varchar);
* CREATE TABLE endangeredAnimals(id serial PRIMARY KEY,name varchar, health VARCHAR, age VARCHAR;
* CREATE TABLE locations (id serial PRIMARY KEY,name VARCHAR);
* CREATE TABLE sightings (id serial PRIMARY KEY,animal_id INT, rangerName varchar, location VARCHAR);
Create a test database by typing the command: CREATE DATABASE wildlife_tracking_test WITH TEMPLATE wildlife_tracking;

## Technologies Used
* JDK
* Junit
* Java
* SDK
* IntellijIDEA
* Bootstrap
* Gradle 
* maven
* Spark
* CSS


## Support and contact details
If you want to contact me, email me on stevenjeri254@gmail.com

### License
*This project is protected under [MIT License](License)*

Copyright (c) 2021 **STEPHEN NJERI**