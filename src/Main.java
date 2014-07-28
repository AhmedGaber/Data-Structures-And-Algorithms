import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import Algorithms.Shuffle;
import Algorithms.Sort.BubbleSort;
import Algorithms.Sort.InsertionSort;
import Algorithms.Sort.MergSort;
import Algorithms.Sort.QuickSort;
import Algorithms.Sort.SelectionSort;
import Algorithms.Sort.ShellSort;
import DataStructures.Bag;
import DataStructures.Union_Find;
import DataStructures.Queue.Deque;
import DataStructures.Queue.LinkedListQueue;
import DataStructures.Stack.ArrayStack;

public class Main {

    static Union_Find UF = new Union_Find(10);
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Comparable<Integer>[] a = new Integer[100000];
        Random r = new Random();
        System.out.println("Before Sort: ");
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100000);
           // System.out.print(a[i] + " ");
        }
        new MergSort().sort(a);
        System.out.println("\nAfter Sorting");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
        // LinkedListQueue<Integer> d = new LinkedListQueue<>();
        // for (int i = 0; i < 10; i++) {
        // d.enqueue(i);
        // }
        // Iterator i = d.iterator();
        // while (i.hasNext())
        // System.out.println(i.next());

    }

}
