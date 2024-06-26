package part_2_1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * BST is a simple implementation of a binary search tree.
 * @param <K> the type of keys, must be comparable
 * @param <V> the type of values
 */
public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node> {
    private Node root;
    private int size = 0;

    // Inner class representing a node in the BST
    public class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }

    // Insert a key-value pair into the BST
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    // Retrieve the value associated with a given key
    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    // Delete a key-value pair from the BST
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
            size--;
        }
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    // Return the size of the BST
    public int size() {
        return size;
    }

    // Return an iterator for in-order traversal of the BST
    public Iterator<Node> iterator() {
        List<Node> nodes = new ArrayList<>();
        inOrder(root, nodes);
        return nodes.iterator();
    }

    private void inOrder(Node x, List<Node> nodes) {
        if (x == null) return;
        inOrder(x.left, nodes);
        nodes.add(x);
        inOrder(x.right, nodes);
    }
}

