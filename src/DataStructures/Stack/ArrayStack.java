package DataStructures.Stack;

import java.util.Iterator;

public class ArrayStack<Type> implements Iterable<Type> {
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

    @Override
    public Iterator<Type> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Type> {
        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Type next() {
            return stack[--i]; // don't know whether to decrease size or i
                               // Java's implementation decreases i
        }

        // not allowed
        @Override
        public void remove() {
        }

    }

}
