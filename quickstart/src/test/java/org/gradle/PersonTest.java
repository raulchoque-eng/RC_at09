package org.gradle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * PersonTest class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class PersonTest {

    /**
     * Method to can construct a person with name.
     */
    @Test
    public void canConstructAPersonWithAName() {
        Person person = new Person("Larry");
        assertEquals("Larry", person.getName());
    }
}
