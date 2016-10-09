package ro.siit.j4;

public class BubbleSort implements SortAlgorithm {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] unsorted) {
		
		boolean inOrder = false;
		int n = unsorted.length;
		while(!inOrder) {
			inOrder = true; // we assume that the array is sorted 
			for(int i = 1; i < n; i++) {
				if(unsorted[i-1].compareTo(unsorted[i]) > 0) {
					swap(unsorted, i);
					inOrder = false;
				}
			}
		}
		return unsorted;
	}

	private <T extends Comparable<T>> void swap(T[] unsorted, int i) {
		T temp = unsorted[i-1];
		unsorted[i-1] = unsorted[i];
		unsorted[i] = temp;
	}
}
