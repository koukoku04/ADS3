package part_2_2;

import part_2_1.BST;

public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();

        bst.put(10, "Value 10");
        bst.put(5, "Value 5");
        bst.put(15, "Value 15");
        bst.put(3, "Value 3");
        bst.put(7, "Value 7");

        System.out.println("Value associated with key 3: " + bst.get(3));

        bst.delete(3);

        System.out.println("Value associated with key 3 after deletion: " + bst.get(3));

        System.out.println("Keys and values in ascending order:");
        for (var node : bst) {
            System.out.println("key is " + node.getKey() + " and value is " + node.getValue());
        }
    }
}

