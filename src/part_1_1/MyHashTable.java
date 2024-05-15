package part_1_1;
import java.util.Random;
import java.util.Random;

/**
 * MyHashTable is a simple implementation of a hash table using separate chaining.
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public class MyHashTable<K, V> {

    // Inner class representing a node in the chain
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11; // default number of chains
    private int size;

    // Default constructor
    public MyHashTable() {
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
    }

    // Constructor with specified number of chains
    public MyHashTable(int M) {
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
        this.M = M;
    }

    // Hash function
    private int hash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % M);
    }

    // Insert a key-value pair into the hash table
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        node = new HashNode<>(key, value);
        node.next = chainArray[index];
        chainArray[index] = node;
        size++;
    }

    // Retrieve the value associated with a given key
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    // Remove a key-value pair from the hash table
    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> previous = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (previous == null) {
                    chainArray[index] = node.next;
                } else {
                    previous.next = node.next;
                }
                size--;
                return node.value;
            }
            previous = node;
            node = node.next;
        }
        return null;
    }

    // Check if a value exists in the hash table
    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    // Retrieve the key associated with a given value
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    // Print the number of elements in each bucket
    public void printBucketSizes() {
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                count++;
                node = node.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}
