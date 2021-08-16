package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

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

    @Test
    public void equals_returnsTrueIfAnimalsAreSame_true() {
        Animal animal = new Animal("Leopard");
        Animal anotherAnimal = new Animal("Leopard");
        assertTrue(animal.equals(anotherAnimal));
    }

    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame() {
        Animal animal = new Animal("Leopard");
        animal.save();
        assertEquals(Animal.all().get(0), animal);
    }

}