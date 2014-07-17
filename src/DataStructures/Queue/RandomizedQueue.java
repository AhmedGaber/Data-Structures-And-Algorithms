package DataStructures.Queue;

import java.util.Iterator;
import java.util.Random;

import Algorithms.Shuffle;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size;
    private int next;
    private Item[] a;

    /**
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
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
        if (item == null)
            throw new NullPointerException();
        if (next == a.length)
            resize(2 * a.length);
        a[next] = item;
        next++;
        size++;
    }

    /**
     * delete and return a random item
     * 
     * @return
     */
    public Item dequeue() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        int n = new Random().nextInt(next); // Get an index at random, swap this
                                            // index with "next" index, return
                                            // it's value and remove it.
        exch(a, next - 1, n);
        Item i = a[--next];
        size--;
        if (size > 0 && size == a.length / 4)
            resize(a.length / 2);
        return i;
    }

    /**
     * return (but do not delete) a random item
     * 
     * @return
     */
    public Item sample() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        return a[new Random().nextInt(next)];
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
            this.i = next - 1;
            this.ar = a;
            if (i > 0)
                new Shuffle().shuffle(ar, 0, i - 1);
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
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
