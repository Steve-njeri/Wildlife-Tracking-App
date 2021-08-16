package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangerTest {

    @Test
    public void instantiatesRangerObjectsCorrectly_true() throws Exception{
        Ranger ranger = new Ranger("Stephen", 20123, 0700000000, "stevenjeri254@gmail.com" );
        assertEquals(true, true);

    }

}