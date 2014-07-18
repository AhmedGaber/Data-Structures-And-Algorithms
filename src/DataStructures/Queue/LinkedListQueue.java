package DataStructures.Queue;

import java.util.Iterator;

public class LinkedListQueue<Item> implements Iterable<Item> {

    private int size;
    private Node<Item> first;
    private Node<Item> last;

    // helper linked list class
    private class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    /**
     * construct an empty deque
     */
    public LinkedListQueue() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    /**
     * is the deque empty?
     * 
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the number of items on the deque
     * 
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * insert the item at the front
     * 
     * @param item
     */
    private void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException();
        if (isEmpty()) {
            first = new Node<Item>();
            last = new Node<Item>();
            first.item = item;
            last = first;
        } else {
            Node<Item> node = new Node<Item>();
            node.item = item;
            node.next = first;
            first.prev = node;
            node.prev = null;
            first = node;
        }
        size++;
    }

    /**
     * insert the item at the end
     * 
     * @param item
     */
    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException();
        if (isEmpty())
            addFirst(item);
        else {
            Node<Item> node = new Node<Item>();
            node.item = item;
            node.prev = last;
            last.next = node;
            node.next = null;
            last = node;
            size++;
        }
    }

    /**
     * delete and return the item at the front
     * 
     * @return
     */
    public Item dequeue() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        else if (size() == 1) {
            Item item = first.item;
            first = null;
            last = null;
            size--;
            return item;
        }
        Item item = first.item;
        first = first.next;
        first.prev = null;
        size--;
        return item;
    }

    /**
     * return an iterator over items in order from front to end
     */
    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Node<Item> current;

        public QueueIterator() {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            if (first == null)
                return false;
            return !(current == null);
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            Item x = current.item;
            current = current.next;
            return x;
        }

        // not allowed
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}