package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.sql2o.Connection;


import static org.junit.Assert.*;

public class RangerTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void RangerObjectsInstantiateCorrectly_true() {
        Ranger ranger = new Ranger("Stephen", 12345);
        assertEquals(true, ranger instanceof Ranger);
    }

    @Test
    public void rangerNameReturnsCorrectly_String() {
        Ranger ranger = new Ranger("Stephen", 12345);
        assertEquals("Stephen", ranger.getName());
    }

    @Test
    public void Ranger_instantiatesWithAnId() {
        Ranger ranger = new Ranger("Stephen", 12345);
        ranger.save();
        assertTrue(ranger.getId()>0);
    }


    @Test
    public void rangersReturnsCorrectly_int() {
        Ranger ranger = new Ranger("Stephen", 12345);
        assertEquals(12345,ranger.getBadge_number());
    }

    @Test
    public void save_toDatabase(){
        Ranger ranger = new Ranger("Stephen", 12345);
        ranger.save();
        Ranger savedRanger = Ranger.all().get(0);
        assertEquals(ranger.getId(), savedRanger.getId());
    }

    @Test
    public void sighted_instantiateSave_true(){
        Ranger ranger = new Ranger("Stephen", 12345);
        ranger.save();
        assertEquals(Ranger.all().get(0).getId(),ranger.getId());
    }

}