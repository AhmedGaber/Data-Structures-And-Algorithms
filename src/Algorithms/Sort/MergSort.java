package Algorithms.Sort;

public class MergSort {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    /**
     * bottom-up Merge Sort Algorithm
     * 
     * @param a
     *            original array
     */
    public static void BottomUpMergeSort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        for (int i = 1; i < aux.length; i += i) {
            for (int j = 0; j < aux.length - i; j += i + i) {
                merge(a, aux, j, i + j - 1,
                        Math.min(j + i + i - 1, aux.length - 1));
            }
        }
    }

    /**
     * top-down (recursive) Merge Sort Algorithm
     * 
     * @param a
     *            original array
     * @param aux
     *            temporary array
     * @param lo
     *            lower index
     * @param hi
     *            higher index
     */
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        if (!less(a[mid + 1], a[mid]))
            return;
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Merging method
     * 
     * @param a
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] a, Comparable[] aux, int lo,
            int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
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
