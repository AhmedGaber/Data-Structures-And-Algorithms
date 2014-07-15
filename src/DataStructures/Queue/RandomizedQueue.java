package DataStructures.Queue;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private int size;
	int next;
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
		if (next == a.length)
			resize(2 * a.length);
		a[next] = item;
	}

	/**
	 * delete and return a random item
	 * 
	 * @return
	 */
	public Item dequeue() {
		if (isEmpty()) {
			// throw an exception here
		}
		return a[next--];
	}

	/**
	 * return (but do not delete) a random item
	 * 
	 * @return
	 */
	public Item sample() {
		if (isEmpty()) {
			// throw an exception here
		}
		return a[next];
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

		public RQIterator() {
			this.i = size;
		}

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new java.util.NoSuchElementException("No item to return.");
			return a[--i];
		}

		// not allowed
		@Override
		public void remove() {
			throw new UnsupportedOperationException(
					"remove() is an unSupported operation");
		}

	}

	private void resize(int capacity) {
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	/**
	 * unit testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
