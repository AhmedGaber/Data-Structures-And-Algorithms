package Algorithms.Sort;

public class SelectionSort {
	public static void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[min]))
					min = j;
				exch(a, i, min);
			}
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
