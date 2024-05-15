package part_1_2;

import java.util.Random;
/**
 * TestingField is a class used to test the MyHashTable.
 * It contains a custom hashCode method to ensure uniform distribution.
 */
public class TestingField {
    private int id;

    public TestingField(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        // Custom hash function for TestingField
        int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TestingField that = (TestingField) obj;
        return id == that.id;
    }
}
