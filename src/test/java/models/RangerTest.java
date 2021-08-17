package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangerTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void instantiatesRangerObjectsCorrectly_true() throws Exception{
        Ranger ranger = new Ranger("Stephen", 20123, 0700000000, "stevenjeri254@gmail.com" );
        assertTrue(ranger instanceof Ranger);

    }

    @Test
    public void rangerNameReturnsCorrectly_String() throws Exception{
        Ranger ranger = new Ranger("Stephen", 20123, 0700000000, "stevenjeri254@gmail.com" );
        assertEquals("Stephen",ranger.getName());
    }

    @Test
    public void rangerTagNumberReturnsCorrectly_String() {
        Ranger ranger = new Ranger("Stephen", 20123, 0700000000, "stevenjeri254@gmail.com" );
        assertEquals(20123,ranger.getBadge_number());
    }

    @Test
    public void rangerMobileNumberReturnsCorrectly_int() throws Exception{
        Ranger ranger = new Ranger("Stephen", 20123, 0700000000, "stevenjeri254@gmail.com" );
        assertEquals(0700000000,ranger.getPhone_number());
    }

    @Test
    public void rangerEmailReturnsCorrectly_String() throws Exception{
        Ranger ranger = new Ranger("Stephen", 20123, 0700000000, "stevenjeri254@gmail.com" );
        assertEquals("stevenjeri254@gmail.com",ranger.getEmail());
    }

    @Test
    public void equals_returnsTrueIfNameAndPersonIdAreSame_true() {
        Ranger ranger = new Ranger("Stephen", 20123, 0700000000, "stevenjeri254@gmail.com" );
        Ranger anotherRanger = new Ranger("Stephen", 20123, 0700000000, "stevenjeri254@gmail.com" );
        assertTrue(ranger .equals(anotherRanger));
    }

    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame() {
        Ranger ranger = new Ranger("Stephen", 20123, 0700000000, "stevenjeri254@gmail.com" );
        ranger.save();
        assertTrue(Ranger.all().get(0).equals(ranger));
    }

    @Test
    public void save_assignsIdToRanger() {
        Ranger ranger = new Ranger("Stephen", 20123, 0700000000, "stevenjeri254@gmail.com" );
        ranger.save();
        Ranger savedRanger = Ranger.all().get(0);
        assertEquals(savedRanger.getId(), ranger.getId());
    }

    @Test
    public void all_returnsAllInstancesOfRanger_true() {
        Ranger ranger = new Ranger("Stephen", 20123, 0700000000, "stevenjeri254@gmail.com" );
        ranger.save();
        Ranger secondRanger = new Ranger("Stephen", 54321, 0710000000, "stevenjeri33@gmail.com" );
        ranger.save();
        assertEquals(true,  Ranger.all().get(0).equals(ranger));
        assertEquals(true,  Ranger.all().get(1).equals(secondRanger));
    }

    @Test
    public void find_returnsRangerWithSameId_secondRanger() {
        Ranger ranger = new Ranger("Stephen", 20123, 0700000000, "stevenjeri254@gmail.com" );
        ranger.save();
        Ranger secondRanger = new Ranger("Stephen", 54321, 0710000000, "stevenjeri33@gmail.com" );
        ranger.save();
        assertEquals(Ranger.find(secondRanger.getId()), secondRanger);
    }

}