package part_1_2;

import part_1_1.MyHashTable;

import java.util.Random;
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
