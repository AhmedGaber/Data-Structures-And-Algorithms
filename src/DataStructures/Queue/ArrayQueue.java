package DataStructures.Queue;

import java.util.Iterator;
import java.util.Random;

import Algorithms.Shuffle;

public class ArrayQueue<Item> implements Iterable<Item> {

    private int size;
    private int next;
    private Item[] a;

    /**
     * construct an empty randomized queue
     */
    public ArrayQueue() {
        this.size = 0;
        this.next = 0;
        a = (Item[]) new Object[2];
    }

    /**
     * is the queue empty?
     * 
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the number of items on the queue
     * 
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * add the item
     * 
     * @param item
     */
    public void enqueue(Item item) {
    }

    /**
     * delete and return a random item
     * 
     * @return
     */
    public Item dequeue() {
    }

    /**
     * return (but do not delete) a random item
     * 
     * @return
     */
    public Item sample() {
    }

    /**
     * return an independent iterator over items in random order
     * 
     * @return
     */
    @Override
    public Iterator<Item> iterator() {
        return new RQIterator();
    }

    private class RQIterator implements Iterator<Item> {
        private int i;
        private Item[] ar;

        public RQIterator() {
        }

        @Override
        public boolean hasNext() {
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            return ar[i--];
        }

        // not allowed
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < next; i++) {
            temp[i] = a[i];
        }
        this.a = temp;
    }

    private void exch(Item[] array, int i, int j) {
        Item k = array[i];
        array[i] = array[j];
        array[j] = k;
    }
}
