import java.util.Random;
import java.util.Scanner;

import Algorithms.Sort.InsertionSort;
import Algorithms.Sort.SelectionSort;
import Algorithms.Sort.ShellSort;
import DataStructures.Bag;
import DataStructures.Union_Find;
import DataStructures.Stack.ArrayStack;

public class Main {

	static Union_Find UF = new Union_Find(10);
	Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Comparable<Integer>[] a = new Integer[20];
		Random r = new Random();
		System.out.println("Before Sort: ");
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(21);
			System.out.print(a[i] + " ");
		}
		System.out.println("\n" + a.length);
		new ShellSort().sort(a);
		System.out.println("\nAfter Sorting");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n" + a.length);
	}

}
