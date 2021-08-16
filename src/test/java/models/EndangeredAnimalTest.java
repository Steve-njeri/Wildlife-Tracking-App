package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Test
    public void endangeredAnimalObjectsInstantiateCorrectly_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        assertEquals(true, endangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void endangeredAnimalNameReturnsCorrectly_String() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        assertEquals("Antelope", endangeredAnimal.getName());
    }

    @Test
    public void endangeredAnimalHealthStatusReturnsCorrectly_int() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        assertEquals("Healthy", endangeredAnimal.getHealth());
    }

    @Test
    public void endangeredAnimalAgeReturnsCorrectly_String() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        assertEquals("Young", endangeredAnimal.getAge());
    }

    @Test
    public void endangeredAnimal_returnsTrueIfAnimalsAreSame_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        assertTrue(endangeredAnimal.equals(secondEndangeredAnimal));
    }

}