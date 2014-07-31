package DataStructures.BinarySearchTree;

import org.w3c.dom.NodeList;

/**
 * An Implementation of the Binary Search Tree
 * 
 * @author Ahmed Gaber
 * 
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    /**
     * Node is the basic structure of the tree.
     * 
     * @author Ahmed Gaber
     * 
     */
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int couunt; // number of nodes in this node's subtree

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Associates value with key.
     * 
     * @param key
     * @param val
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        return node;
    }

    /**
     * Returns value corresponding to given key, or null if no such key
     * 
     * @param key
     * @return
     */
    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return node.value;
        }
        return null;
    }

    /**
     * Deletes a value from the tree
     * 
     * @param key
     */
    public void delete(Key key) {
    }

    /**
     * Returns an Iterator over all values in the tree
     * 
     * @return
     */
    public Iterable<Key> iterator() {
    }
}