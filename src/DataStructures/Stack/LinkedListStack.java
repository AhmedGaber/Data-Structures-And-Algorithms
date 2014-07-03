package DataStructures.Stack;

public class LinkedListStack<Type> {
	private int size;
	private Node first;

	private class Node {
		Type data;
		Node next;
	}

	public LinkedListStack() {
		this.first = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(Type data) {
		Node old = first;
		first = new Node();
		first.data = data;
		first.next = old;
		size++;
	}

	public Type pop() {
		Type data = first.data;
		first = first.next;
		size--;
		return data;
	}

	public int size() {
		return size;
	}
}
