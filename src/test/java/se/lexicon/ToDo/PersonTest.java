package se.lexicon.ToDo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PersonTest {

    private Person person;

    @BeforeEach
    void setup() {
        person = new Person("John", "Doe", "john.doe@example.com", 1);
    }

    @Test
    void getId() {
        assertEquals(1, person.getId());
    }

    @Test
    void getFirstName() {
        assertEquals("John", person.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Doe", person.getLastName());
    }

    @Test
    void getEmail() {
        assertEquals("john.doe@example.com", person.getEmail());
    }

    @Test
    void setFirstName() {
        person.setFirstName("Jane");
        assertEquals("Jane", person.getFirstName());

        // Ensure null values do not change the first name
        person.setFirstName(null);
        assertEquals("Jane", person.getFirstName());
    }

    @Test
    void setLastName() {
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName());

        // Ensure null values do not change the last name
        person.setLastName(null);
        assertEquals("Smith", person.getLastName());
    }

    @Test
    void setEmail() {
        person.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", person.getEmail());

        // Ensure null values do not change the email
        person.setEmail(null);
        assertEquals("jane.smith@example.com", person.getEmail());
    }

    @Test
    void getSummary() {
        String expectedSummary = "Id : 1, Name : John Doe, Email : john.doe@example.com";
        assertEquals(expectedSummary, person.getSummary());
    }

    @Test
    void constructorInitializationWithSequencer() {
        // Reset sequencer before testing sequential ID assignment
        Person person1 = new Person("Alice", "Brown", "alice.brown@example.com");
        Person person2 = new Person("Bob", "Green", "bob.green@example.com");

        assertEquals(person1.getId() + 1, person2.getId());
    }
}