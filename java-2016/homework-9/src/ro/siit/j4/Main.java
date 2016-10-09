package ro.siit.j4;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		SortAlgorithm bubbleSort = new BubbleSort();
		Integer [] unsorted = new Integer [] {10, 5, 1, 3, 2 , 15, 6, 13};
		Integer [] sorted = bubbleSort.sort(unsorted);
		System.out.println(Arrays.toString(sorted));
	}
}
