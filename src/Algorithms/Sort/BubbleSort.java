package Algorithms.Sort;

public class BubbleSort {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = 1; j < a.length - i; j++)
                if (less(a[j], a[j - 1]))
                    exch(a, j - 1, j);

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
