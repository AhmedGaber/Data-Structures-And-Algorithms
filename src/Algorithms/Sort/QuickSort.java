package Algorithms.Sort;

import Algorithms.Shuffle;

/**
 * This class takes an array of any type and sort it
 * 
 * @author Gaber
 * 
 */
public class QuickSort {
    /**
     * Call this method with the original array to be sorted
     * 
     * @param a
     *            original array
     */
    public static void sort(Comparable[] a) {
        new Shuffle().shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * A recursive method that do the sorting work
     * 
     * @param a
     *            original array
     * @param lo
     *            lower index to start from
     * @param hi
     *            upper index to check last
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * This method partitions the array and doing the merging work
     * 
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo]))
                if (i == hi)
                    break;
            while (less(a[lo], a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    /**
     * Check if an object is less than another
     * 
     * @param p
     * @param q
     * @return
     */
    private static boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) < 0;
    }

    /**
     * Exchanges two indexes in the array
     * 
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable k = a[i];
        a[i] = a[j];
        a[j] = k;
    }

}
