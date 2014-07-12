package Algorithms;

import java.util.Random;

public class Shuffle {

	public static void shuffle(Object[] a) {
		for (int i = 0; i < a.length; i++) {
			Random r = new Random();
			exch(a, i, r.nextInt(i + 1));
		}
	}

	private static void exch(Object[] a, int i, int j) {
		Object k = a[i];
		a[i] = a[j];
		a[j] = k;
	}
}
