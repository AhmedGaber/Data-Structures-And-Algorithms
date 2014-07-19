package DataStructures.Stack;

import java.util.Iterator;

public class LinkedListStack<Type> implements Iterable<Type> {
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
        if (size < 0)
            throw new IndexOutOfBoundsException("No more items in the stack!");
        Type data = first.data;
        first = first.next;
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Type> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Type> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Type next() {
            Type x = current.data;
            current = current.next;
            return x;
        }

        // not allowed
        @Override
        public void remove() {
        }

    }
}
