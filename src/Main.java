import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import Algorithms.Shuffle;
import Algorithms.Sort.InsertionSort;
import Algorithms.Sort.SelectionSort;
import Algorithms.Sort.ShellSort;
import DataStructures.Bag;
import DataStructures.Union_Find;
import DataStructures.Queue.Deque;
import DataStructures.Stack.ArrayStack;

public class Main {

	static Union_Find UF = new Union_Find(10);
	Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Comparable<Integer>[] a = new Integer[20];
		// Random r = new Random();
		// System.out.println("Before Sort: ");
		// for (int i = 0; i < a.length; i++) {
		// a[i] = r.nextInt(21);
		// System.out.print(a[i] + " ");
		// }
		// new ShellSort().sort(a);
		// System.out.println("\nAfter Sorting");
		// for (int i = 0; i < a.length; i++) {
		// System.out.print(a[i] + " ");
		// }
		// new Shuffle().shuffle(a);
		// System.out.println("\nAfter Shuffling");
		// for (int i = 0; i < a.length; i++) {
		// System.out.print(a[i] + " ");
		// }

		Deque<Integer> d = new Deque<>();
		for (int i = 0; i < 10; i++) {
			d.addLast(i);
		}
		Iterator i = d.iterator();
		while (i.hasNext())
			System.out.println(i.next());
		System.out.println(i.next());
	}

}
