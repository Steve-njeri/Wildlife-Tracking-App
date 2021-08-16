package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangerTest {

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

}