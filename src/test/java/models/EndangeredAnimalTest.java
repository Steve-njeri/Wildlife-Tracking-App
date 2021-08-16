package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Test
    public void endangeredAnimalObjectsInstantiateCorrectly_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "healthy", "Young");
        assertEquals(true, endangeredAnimal instanceof EndangeredAnimal);
    }

}