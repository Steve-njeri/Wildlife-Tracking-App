package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredAnimalObjectsInstantiateCorrectly_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        assertTrue(true);
    }

    @Test
    public void endangeredAnimalNameReturnsCorrectly_String() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        assertEquals("Antelope", endangeredAnimal.getName());
    }

    @Test
    public void endangeredAnimalHealthStatusReturnsCorrectly_int() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        assertEquals("Healthy", endangeredAnimal.getHealth());
    }

    @Test
    public void endangeredAnimalAgeReturnsCorrectly_String() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        assertEquals("Young", endangeredAnimal.getAge());
    }

    @Test
    public void endangeredAnimal_returnsTrueIfAnimalsAreSame_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        assertEquals(endangeredAnimal, secondEndangeredAnimal);
    }

    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        endangeredAnimal.save();
        assertEquals(EndangeredAnimal.all().get(0), endangeredAnimal);
    }

    @Test
    public void save_toDatabase(){
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        endangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(endangeredAnimal.getId(), savedEndangeredAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        endangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Lion", "Healthy", "Adult");
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.all().get(0), endangeredAnimal);
        assertEquals(EndangeredAnimal.all().get(1), secondEndangeredAnimal);
    }

    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Antelope", "Healthy", "Young");
        endangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Lion", "Healthy", "Adult");
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }

}