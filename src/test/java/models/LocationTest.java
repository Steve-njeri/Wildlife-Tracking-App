package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Location_instantiatesCorrectly_true(){
        Location location = new Location("Zone A");
        assertEquals(true, location instanceof Location);
    }

    @Test
    public void Location_instantiatesWithName_String() {
        Location location = new Location("Zone A");
        assertEquals("Zone A", location.getName());
    }

    @Test
    public void save_savesCorrectly() {
        Location location = new Location("Zone A");
        location.save();
        assertTrue(Location.all().get(0).equals(location));
    }

    @Test
    public void equals_returnsTrueIfLocationsAreSame(){
        Location location = new Location("Zone A");
        Location secondLocation = new Location("Zone A");
        assertTrue(location.equals(secondLocation ));
    }

    @Test
    public void save_returnsTrueIfNamesAreTheSame(){
        Location location = new Location("Zone A");
        location.save();
        assertEquals(Location.all().get(0), location);
    }

    @Test
    public void save_assignsIdToObject() {
        Location location = new Location("Zone A");
        location.save();
        Location savedLocation = Location.all().get(0);
        assertEquals(location.getId(), savedLocation.getId());
    }

    @Test
    public void all_returnsAllInstancesOfLocations_true(){
        Location location = new Location("Zone A");
        location.save();
        Location secondLocation = new Location("Zone B");
        secondLocation.save();
        assertEquals(Location.all().get(0), location);
        assertEquals(Location.all().get(1), secondLocation);
    }

    @Test
    public void find_returnsLocationWIthSameID_secondLocation(){
        Location location = new Location("Zone A");
        location.save();
        Location secondLocation = new Location("Zone B");
        secondLocation.save();
        assertEquals(Location.find(secondLocation.getId()), secondLocation);
    }

}