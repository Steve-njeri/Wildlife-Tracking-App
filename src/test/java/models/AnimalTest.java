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

    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animal animal = new Animal("Leopard");
        animal.save();
        Animal secondAnimal = new Animal("Elephant");
        secondAnimal.save();
        assertEquals(Animal.all().get(0), animal);
        assertEquals(Animal.all().get(1), secondAnimal);
    }

    @Test
    public void save_assignsIdToAnimal() {
        Animal animal = new Animal("Leopard");
        animal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(savedAnimal.getId(), animal.getId());
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal animal = new Animal("Leopard");
        animal.save();
        Animal secondAnimal = new Animal("Elephant");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

    @Test
    public void delete_deletesAnimal_true(){
        Animal animal = new Animal("Leopard");
        animal.save();
        int animalId = animal.getId();
        animal.delete();
        assertEquals(null, Animal.find(animalId));
    }


}