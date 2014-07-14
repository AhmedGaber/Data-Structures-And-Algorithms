package DataStructures.Queue;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

	private int size;
	private Node first;
	private Node last;

	private class Node {
		Node next;
		Node prev;
		Item item;
	}

	/**
	 * construct an empty deque
	 */
	public Deque() {
		this.size = 0;
		this.first = new Node();
		this.last = new Node();
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
	public void addFirst(Item item) {
		if (item == null)
			throw new NullPointerException("Null is not a valid input");
		if (isEmpty()) {
			this.first.item = item;
			this.last = first;
		} else {
			Node node = new Node();
			node.item = item;
			node.next = first;
			first.prev = node;
			node.prev = null;
			this.first = node;
		}
		size++;
	}

	/**
	 * insert the item at the end
	 * 
	 * @param item
	 */
	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException("Null is not a valid input");
		if (isEmpty())
			addFirst(item);
		else {
			Node node = new Node();
			node.item = item;
			node.prev = last;
			last.next = node;
			node.next = null;
			this.last = node;
			size++;
		}
	}

	/**
	 * delete and return the item at the front
	 * 
	 * @return
	 */
	public Item removeFirst() {
		if (isEmpty())
			throw new java.util.NoSuchElementException("Deque is empty.");
		else if (size() == 1) {
			Item item = first.item;
			first = null;
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
	 * delete and return the item at the end
	 * 
	 * @return
	 */
	public Item removeLast() {
		if (isEmpty())
			throw new java.util.NoSuchElementException("Deque is empty.");
		else if (size() == 1)
			return removeFirst();
		Item item = last.item;
		last = last.prev;
		last.next = null;
		size--;
		return item;
	}

	/**
	 * return an iterator over items in order from front to end
	 */
	@Override
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}

	private class DequeIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current.next != null;
		}

		@Override
		public Item next() {
			if (current.item == null)
				throw new java.util.NoSuchElementException("No item to return.");
			Item x = current.item;
			current = current.next;
			return x;
		}

		// not allowed
		@Override
		public void remove() {
			throw new UnsupportedOperationException(
					"remove() is an unSupported operation");
		}

	}

}