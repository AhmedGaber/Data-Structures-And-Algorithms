package Algorithms.Sort;

import Algorithms.Shuffle;

public class ThreeWayQuickSort {

    public static void sort(Comparable[] a) {
        new Shuffle().shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int comp = a[i].compareTo(v);
            if (comp < 0)
                exch(a, lt++, i++);
            else if (comp > 0)
                exch(a, i, gt--);
            else
                i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo]))
                if (i == hi)
                    break;
            while (less(a[lo], a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable k = a[i];
        a[i] = a[j];
        a[j] = k;
    }
}
