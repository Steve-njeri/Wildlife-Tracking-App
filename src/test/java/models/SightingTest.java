package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {

    @Test
    public void Sighting_instantiatesCorrectly_true(){
        Sighting sighting = new Sighting(1,"zone A","John");
        assertEquals(true, sighting instanceof Sighting);
    }

}