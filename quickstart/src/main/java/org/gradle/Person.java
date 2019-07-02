package org.gradle;

import org.apache.commons.collections.list.GrowthList;

/**
 * Person class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Person {
    private final String name;

    /**
     * Constructor method.
     * @param name is name person
     */
    public Person(final String name) {
        this.name = name;
        new GrowthList();
    }

    /**
     * Return as a string the name.
     * @return as a string a name
     */
    public String getName() {
        return name;
    }
}
