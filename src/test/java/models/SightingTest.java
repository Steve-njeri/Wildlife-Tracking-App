package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

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

    @Test
    public void save_insertsObjectIntoDatabase() {
        Sighting sighting = new Sighting(1,"zone A","John");
        sighting.save();
        assertTrue(Sighting.all().get(0).equals(sighting));
    }

    @Test
    public void save_assignsIdToObject() {
        Sighting sighting = new Sighting(1,"zone A","John");
        sighting.save();
        Sighting savedSighting = Sighting.all().get(0);
        assertEquals(sighting.getId(), savedSighting.getId());
    }

    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        Sighting sighting = new Sighting(1,"zone A","John");
        sighting.save();
        Sighting secondSighting = new Sighting(1,"zone B","James");
        sighting.save();
        assertEquals(true,Sighting.all().get(0).equals(sighting));
        assertEquals(true, Sighting.all().get(1).equals(secondSighting));
    }

    @Test
    public void find_returnsMonsterWithSameId_secondMonster() {
        Sighting sighting = new Sighting(1,"zone A","John");
        sighting.save();
        Sighting secondSighting = new Sighting(1,"zone B","James");
        sighting.save();
        assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
    }

}