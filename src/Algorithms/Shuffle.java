package Algorithms;

import java.util.Random;

public class Shuffle {

    public void shuffle(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            Random r = new Random();
            exch(a, i, r.nextInt(i + 1));
        }
    }

    private void exch(Object[] a, int i, int j) {
        Object k = a[i];
        a[i] = a[j];
        a[j] = k;
    }

    public void shuffle(Object[] a, int p, int q) {
        for (int i = p; i < q; i++) {
            Random r = new Random();
            exch(a, i, r.nextInt(i + 1));
        }
    }
}
