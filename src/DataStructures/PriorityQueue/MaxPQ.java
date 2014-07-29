package DataStructures.PriorityQueue;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    private int next;

    public void MaxPQ() {
        pq = (Key[]) new Comparable[2];
    }

    public void MaxPQ(Key[] a) {
        this.pq = a;
    }

    public void insert(Key v) {
        if (N == pq.length)
            resize(pq.length * 2);
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        if (N > 0 && N == pq.length / 4)
            resize(pq.length / 2);
        // modify that
        return null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Key max() {
        return pq[0];
    }

    public int size() {
        return N;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {

    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void resize(int capacity) {
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 0; i < next; i++) {
            temp[i] = pq[i];
        }
        this.pq = temp;
    }

}
