import java.util.Random;

class TestingField {
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

public class Main {
    public static void main(String[] args) {

        MyHashTable<TestingField, String> table = new MyHashTable<>();

        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(1000);
            TestingField object = new TestingField(id);
            table.put(object, "Value " + i);
        }

        table.printBucketSizes();
    }
}
