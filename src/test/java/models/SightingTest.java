package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {

    @Test
    public void Sighting_instantiatesCorrectly_true(){
        Sighting sighting = new Sighting(1,"zone A","John");
        assertEquals(true, sighting instanceof Sighting);
    }

    @Test
    public void Sighting_instantiatesWithAnimalId() {
        Sighting sighting = new Sighting(1,"zone A","John");
        assertEquals(1, sighting.getAnimal_id());
    }

    @Test
    public void Sighting_instantiatesWithLocation(){
        Sighting sighting = new Sighting(1,"zone A","John");
        assertEquals("zone A", sighting.getLocation());
    }

    @Test
    public void Sighting_instantiatesWithRangerName(){
        Sighting sighting = new Sighting(1,"zone A","John");
        assertEquals("John", sighting.getRangerName());
    }

    @Test
    public void equals_returnsTrueIfAllPropertiesAreTheSame() {
        Sighting sighting = new Sighting(1,"zone A","John");
        Sighting secondSighting = new Sighting(1,"zone A","John");
        assertTrue(sighting.equals(secondSighting));
    }

}