package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

import java.security.Timestamp;
import java.text.DateFormat;
import java.util.Date;

public class SightingTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Sighting_instantiatesCorrectly_true(){
        Sighting sighting = new Sighting(1,"zone A","John");
        assertTrue(true);
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
        assertEquals(sighting, secondSighting);
    }

    @Test
    public void save_assignsIdToObject() {
        Sighting sighting = new Sighting(1,"zone A","John");
        sighting.save();
        Sighting savedSighting = Sighting.getAll().get(0);
        assertEquals(sighting.getId(), savedSighting.getId());
    }

    @Test
    public void sighted_instantiateSave_true(){
        Sighting sighting = new Sighting(1,"zone A","John");
        sighting.save();
        assertEquals(Sighting.getAll().get(0).getId(),sighting.getId());
    }

    @Test
    public void sighted_instantiateClearAll_true(){
        Sighting sighting = new Sighting(1,"zone A","John");
        sighting.save();
        Sighting.clearAll();
        assertEquals(0,Sighting.getAll().size());
    }

    @Test
    public void sighted_instantiateDelete_true(){
        Sighting sighting = new Sighting(1,"zone A","John");
        sighting.save();
        Sighting.delete(sighting.getId());
        assertEquals(0,Sighting.getAll().size());
    }


}