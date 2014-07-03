package DataStructures.Stack;

public class ArrayStack <Type> {
	private int size;
	private Type[] stack;

	public ArrayStack() {
		this.size = 0;
		this.stack = (Type[]) new Object[50];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(Type data) {
		if (size == stack.length)
			resize(2 * stack.length);
		stack[size] = data;
		size++;
	}

	public Type pop() {
		size--;
		if (size < 0)
			throw new IndexOutOfBoundsException("No more items in the stack!");
		Type data = stack[size];
		stack[size] = null;
		if (size > 0 && size == stack.length / 4)
			resize(stack.length / 2);
		return data;

	}

	public int size() {
		return size;
	}

	private void resize(int n) {
		Type[] newArray = (Type[]) new Object[n];
		for (int i = 0; i < size; i++) {
			newArray[i] = stack[i];
		}
		stack = newArray;
	}
}
