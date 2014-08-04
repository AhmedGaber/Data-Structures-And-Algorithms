/**
 * An Implementation of the Red-Black Binary Search Tree
 * 
 * @author Ahmed Gaber
 * 
 * @param <Key>
 * @param <Value>
 */
package DataStructures.SearchTree;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * Node is the basic structure of the tree.
     * 
     * @author Ahmed Gaber
     * 
     */
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        boolean color;
        private int count; // number of nodes in this node's subtree

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private boolean isRed(Node node) {
        if (node == null)
            return false;
        return node.color == RED;

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

    private Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    private Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    private void flipColors(Node node) {
        assert !isRed(node);
        assert isRed(node.left);
        assert isRed(node.right);
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
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
            return new Node(key, value, RED);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right))
            flipColors(node);
        return node;
    }

    /**
     * Returns value corresponding to given key, or null if no such key
     * 
     * @param key
     * @return
     */
    public Value get(Key key) {
        Node temp = root;
        while (temp != null) {
            int cmp = key.compareTo(temp.key);
            if (cmp < 0)
                temp = temp.left;
            else if (cmp > 0)
                temp = temp.right;
            else
                return temp.value;
        }
        return null;
    }
}
