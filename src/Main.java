import java.util.Scanner;

import DataStructures.Bag;
import DataStructures.Union_Find;
import DataStructures.Stack.ArrayStack;

public class Main {

	static Union_Find UF = new Union_Find(10);
	Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Bag bag = new Bag<Integer>();
		for (int i = 2; i < 50; i += 2) {
			bag.add(i);
		}
		while (bag.iterator().hasNext())
			System.out.println(bag.iterator().next());

		System.out.println("=============================");

		ArrayStack stack = new ArrayStack<Integer>();
		for (int i = 2; i < 50; i += 2) {
			stack.push(i);
		}
		java.util.Iterator i = stack.iterator();
		while (i.hasNext())
			System.out.println(i.next());

	}

}
