package DataStructures;

import java.util.Iterator;

public class Bag<Type> implements Iterable<Type> {

	private int size;
	private Type[] data;

	public Bag() {
		this.size = 0;
		this.data = (Type[]) new Object[50];
	}

	public void add(Type i) {
		if (size == data.length)
			resize(2 * data.length);
		data[size] = i;
		size++;
	}

	public int size() {
		return size;
	}

	private void resize(int n) {
		Type[] newArray = (Type[]) new Object[n];
		for (int i = 0; i < size; i++) {
			newArray[i] = data[i];
		}
		data = newArray;
	}

	@Override
	public Iterator<Type> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<Type> {
		private int i = size;

		@Override
		public boolean hasNext() {
			return size > 0;
		}

		@Override
		public Type next() {
			return data[--size];
		}

		@Override
		public void remove() {
			// not allowed
		}

	}
}
