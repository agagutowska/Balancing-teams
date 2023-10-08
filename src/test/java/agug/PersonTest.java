package agug;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    @DisplayName("Test checks creation of object")
    void testPersonCreation() {
        Person person = new Person("Johnny", 8.0);
        assertEquals("Johnny", person.getName());
        assertEquals(8.0, person.getRate());
    }

    @Test
    @DisplayName("Test checks setting and getting name of object")
    void testSetName() {
        Person person = new Person("Johnny", 8.0);
        person.setName("Robbie");
        assertEquals("Robbie", person.getName());
    }

    @Test
    @DisplayName("Test checks setting and getting rate of object")
    void testSetRate() {
        Person person = new Person("Johnny", 8.0);
        person.setRate(9.0);
        assertEquals(9.0, person.getRate());
    }
}
