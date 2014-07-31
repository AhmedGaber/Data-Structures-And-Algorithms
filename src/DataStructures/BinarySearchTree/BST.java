package DataStructures.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

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
        private int count; // number of nodes in this node's subtree

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
        node.count = 1 + size(node.left) + size(node.right);
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
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.right == null)
                return node.left;
            if (node.left == null)
                return node.right;

            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * Returns the node with the minimum value
     * 
     * @return
     */
    public Node min() {
        return min(root);
    }

    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node);
    }

    /**
     * Returns the node with the maximum value
     * 
     * @return
     */
    public Node max() {
        return max(root);
    }

    private Node max(Node node) {
        if (node.right == null)
            return node;
        return min(node);
    }

    /**
     * Returns an Iterator over all values in the tree
     * 
     * @return
     */
    public Iterable<Key> iterator() {
        Queue<Key> q = new LinkedList<Key>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node node, Queue<Key> q) {
        if (node == null)
            return;
        inorder(node.left, q);
        q.add(node.key);
        inorder(node.right, q);
    }

    /**
     * Returns number of nodes in the tree
     * 
     * @return
     */
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        return node.count;
    }

    /**
     * Deletes the node with the minimum value from the tree
     * 
     * @param node
     * @return
     */
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    /**
     * Deletes the node with the maximum value from the tree
     * 
     * @param node
     * @return
     */
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null)
            return node.left;
        node.right = deleteMin(node.right);
        node.count = 1 + size(node.right) + size(node.left);
        return node;
    }

}