package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal animal = new Animal("Leopard");
        assertEquals(true, animal instanceof Animal);
    }

    @Test
    public void animal_instantiatesWithName_String() {
        Animal animal = new Animal("Leopard");
        assertEquals("Leopard", animal.getName());
    }

}