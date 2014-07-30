package DataStructures.PriorityQueue;

import java.util.Scanner;

public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MinPQ() {
        pq = (Key[]) new Comparable[2];
        this.N = -1;
    }

    public MinPQ(Key[] a) {
        this.pq = a;
        this.N = a.length - 1;
        for (int k = N / 2; k >= 0; k--)
            sink(k);
    }

    public void insert(Key v) {
        if (N == pq.length)
            resize(pq.length * 2);
        pq[++N] = v;
        swim(N);
    }

    public Key delMin() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        Key min = pq[0];
        exch(0, N--);
        sink(0);
        pq[N + 1] = null;
        if (N > 0 && N == pq.length / 4)
            resize(pq.length / 2);
        return min;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Key min() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        return pq[1];
    }

    public int size() {
        return N;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }

    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1))
                j++;
            if (!greater(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void resize(int capacity) {
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 0; i <= N; i++) {
            temp[i] = pq[i];
        }
        this.pq = temp;
    }
}
