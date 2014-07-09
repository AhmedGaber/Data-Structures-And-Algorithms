package Algorithms.Sort;

public class ShellSort {

	public static void sort(Comparable[] a) {
		int h = 1;
		while (h < a.length / 3) {
			h = 3 * h + 1; // Knuth sequence
		}
		// h-sorting the array
		while (h >= 1) {
			for (int i = h; i < a.length; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}

			}
			h /= 3;
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
