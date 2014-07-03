import java.util.Scanner;

import DataStructures.Union_Find;

public class Main {

	static Union_Find UF = new Union_Find(10);
	Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		UF.union(4, 3);
		System.out.println(UF.connected(2, 5) ? "Yes!" : "No");
		UF.union(3, 8);
		UF.union(6, 5);
		UF.union(2, 5);
		System.out.println(UF.connected(7, 3) ? "Yes!" : "No");
		UF.union(9, 4);
		UF.print();
		UF.union(2, 1);
		UF.union(5, 0);
		UF.union(7, 2);
		UF.union(6, 1);
		UF.print();
		UF.union(7, 3);
		UF.print();
	}
}
