# Data Structures Project

This project implements two fundamental data structures in Java: a hash table and a binary search tree (BST). The `MyHashTable` class uses separate chaining for collision handling, and the `BST` class implements a basic binary search tree with in-order traversal.

## Table of Contents

- [Classes Overview](#classes-overview)
  - [MyHashTable](#myhashtable)
  - [TestingField](#testingfield)
  - [BST](#bst)
- [How to Run](#how-to-run)
- [Usage Example](#usage-example)
- [License](#license)

## Classes Overview

### MyHashTable

The `MyHashTable` class is a simple implementation of a hash table using separate chaining to handle collisions.

- **Methods:**
  - `public MyHashTable()`: Default constructor initializing the hash table with 11 buckets.
  - `public MyHashTable(int M)`: Constructor to initialize the hash table with a specified number of buckets.
  - `private int hash(K key)`: Computes the hash for a given key.
  - `public void put(K key, V value)`: Inserts a key-value pair into the hash table.
  - `public V get(K key)`: Retrieves the value associated with a given key.
  - `public V remove(K key)`: Removes a key-value pair from the hash table.
  - `public boolean contains(V value)`: Checks if a value exists in the hash table.
  - `public K getKey(V value)`: Retrieves the key associated with a given value.
  - `public void printBucketSizes()`: Prints the number of elements in each bucket.

### TestingField

The `TestingField` class is used to test the `MyHashTable` implementation. It includes a custom `hashCode` method to ensure uniform distribution of hash values.

- **Methods:**
  - `public TestingField(int id)`: Constructor to initialize a `TestingField` object with a given ID.
  - `public int getId()`: Returns the ID of the `TestingField` object.
  - `@Override public int hashCode()`: Custom hash function for `TestingField`.
  - `@Override public boolean equals(Object obj)`: Checks if two `TestingField` objects are equal.

### BST

The `BST` class is a simple implementation of a binary search tree (BST).

- **Inner Class:**
  - `Node`: Represents a node in the BST with a key, value, left child, and right child.
  
- **Methods:**
  - `public void put(K key, V val)`: Inserts a key-value pair into the BST.
  - `public V get(K key)`: Retrieves the value associated with a given key.
  - `public void delete(K key)`: Removes a key-value pair from the BST.
  - `public int size()`: Returns the size of the BST.
  - `public Iterator<Node> iterator()`: Returns an iterator for in-order traversal of the BST.

## How to Run

1. **Compile the code:**

   Ensure you have Java installed on your machine. Open a terminal and navigate to the directory containing the `.java` files, then compile them:

   ```sh
   javac MyHashTable.java TestingField.java BST.java Main.java
2. **Run the main class:**

   ```sh
   java Main

## Usage Example

  Here's an example of how to use the MyHashTable and BST classes:
   ```sh
   public class Main {
    public static void main(String[] args) {
        // Test the BST class
        BST<Integer, String> bst = new BST<>();

        bst.put(10, "Value 10");
        bst.put(5, "Value 5");
        bst.put(15, "Value 15");
        bst.put(3, "Value 3");
        bst.put(7, "Value 7");

        System.out.println("Value associated with key 3: " + bst.get(3));
        bst.delete(3);
        System.out.println("Value associated with key 3 after deletion: " + bst.get(3));

        System.out.println("Keys in ascending order:");
        for (BST<Integer, String>.Node node : bst) {
            System.out.println("key is " + node.getKey() + " and value is " + node.getValue());
        }

        // Test the MyHashTable class
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

