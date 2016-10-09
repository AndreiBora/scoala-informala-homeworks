package ro.siit.j4;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class BubbleSortTest {
	
	@Test
	public void whenTheListHasUnsortedIntegers_sort(){
		SortAlgorithm bubbleSort = new BubbleSort();
		Integer [] unsorted = new Integer [] {10, 5, 1, 3, 2 , 15, 6, 13};
		Integer [] sorted = bubbleSort.sort(unsorted);
		assertArrayEquals(new Integer[] {1,2,3,5,6,10,13,15},sorted);
	}
	
	@Test
	public void whenTheListHasSortedIntegers_sort(){
		SortAlgorithm bubbleSort = new BubbleSort();
		Integer [] unsorted = new Integer [] {1,2,3,5,6,10,13,15};
		Integer [] sorted = bubbleSort.sort(unsorted);
		assertArrayEquals(new Integer[] {1,2,3,5,6,10,13,15},sorted);
	}
	@Test
	public void whenTheListHasOneInteger_sort(){
		SortAlgorithm bubbleSort = new BubbleSort();
		Integer [] unsorted = new Integer [] {1};
		Integer [] sorted = bubbleSort.sort(unsorted);
		assertArrayEquals(new Integer[] {1},sorted);
	}
	
	@Test
	public void whenTheListHasManyIntegers_sort(){
		SortAlgorithm bubbleSort = new BubbleSort();
		Integer [] unsorted = new Integer[10000000];
		Integer [] expected = new Integer[10000000];
		
		for (int i = unsorted.length-1; i >= 0; i--) {
			unsorted[i] = i;
		}
		
		for (int i = 0; i < unsorted.length; i++) {
			expected[i] = i;
		}
		
		
		Integer [] sorted = bubbleSort.sort(unsorted);
		assertArrayEquals(expected,sorted);
	}
	
	@Test
	public void whenTheListHasUnsortedStrings_sort(){
		SortAlgorithm bubbleSort = new BubbleSort();
		String [] unsorted = new String [] {"Ana", "Maria", "Serena", "Simona", "Vanesa" ,"Xenia", "Sara","Anelore"};
		String [] expected = new String[] {"Ana", "Anelore", "Maria", "Sara", "Serena", "Simona", "Vanesa", "Xenia"};
		String [] sorted = bubbleSort.sort(unsorted);
		assertArrayEquals(expected,sorted);
		
	}
	
	@Test
	public void whenTheListHasSortedStrings_sort(){
		SortAlgorithm bubbleSort = new BubbleSort();
		String [] unsorted = new String [] {"Ana", "Anelore", "Maria", "Sara", "Serena", "Simona", "Vanesa", "Xenia"};
		String [] expected = new String[] {"Ana", "Anelore", "Maria", "Sara", "Serena", "Simona", "Vanesa", "Xenia"};
		String [] sorted = bubbleSort.sort(unsorted);
		assertArrayEquals(expected,sorted);
		
	}
	
	@Test
	public void whenTheListHasOneStrings_sort(){
		SortAlgorithm bubbleSort = new BubbleSort();
		String [] unsorted = new String [] {"Ana"};
		String [] expected = new String[] {"Ana"};
		String [] sorted = bubbleSort.sort(unsorted);
		assertArrayEquals(expected,sorted);
		
	}
	@Test
	public void whenTheListHasNoStrings_sort(){
		SortAlgorithm bubbleSort = new BubbleSort();
		String [] unsorted = new String [] {};
		String [] expected = new String[] {};
		String [] sorted = bubbleSort.sort(unsorted);
		assertArrayEquals(expected,sorted);
		
	}
	@Test
	public void whenTheListHasBackwordsSortedStrings_sort(){
		SortAlgorithm bubbleSort = new BubbleSort();
		String [] unsorted = new String [] {"Xenia","Vanesa","Simona","Serena","Sara","Maria","Anelore","Ana"};
		String [] expected = new String[] {"Ana", "Anelore", "Maria", "Sara", "Serena", "Simona", "Vanesa", "Xenia"};
		String [] sorted = bubbleSort.sort(unsorted);
		assertArrayEquals(expected,sorted);
		
	}
	
	@Test
	public void whenTheArrayHasUnorderedAfterWeight_sortDogs() {
		SortAlgorithm bubbleSort = new BubbleSort();
		Dogs afganHound = new Dogs("AfganHound","Pappy",50);
		Dogs australianTerrier = new Dogs("australianTerrier","rex",16);
		Dogs beagle = new Dogs("Beagle","Azor",20);
		
		Dogs [] weightUnsorted = new Dogs [] {afganHound,australianTerrier,beagle};
		Dogs [] expected = new Dogs [] {australianTerrier,beagle,afganHound};
		Dogs [] weightSorted = bubbleSort.sort(weightUnsorted);
		assertArrayEquals(expected,weightSorted);
	}
	
	@Test
	public void whenTheArrayHasOrderedAfterWeight_sortDogs() {
		SortAlgorithm bubbleSort = new BubbleSort();
		Dogs afganHound = new Dogs("AfganHound","Pappy",50);
		Dogs australianTerrier = new Dogs("australianTerrier","rex",16);
		Dogs beagle = new Dogs("Beagle","Azor",20);
		
		Dogs [] weightUnsorted = new Dogs [] {australianTerrier,beagle,afganHound};
		Dogs [] expected = new Dogs [] {australianTerrier,beagle,afganHound};
		Dogs [] weightSorted = bubbleSort.sort(weightUnsorted);
		assertArrayEquals(expected,weightSorted);
	}
	
	@Test
	public void whenTheArrayHasOrderedBackWordsAfterWeight_sortDogs() {
		SortAlgorithm bubbleSort = new BubbleSort();
		Dogs afganHound = new Dogs("AfganHound","Pappy",50);
		Dogs australianTerrier = new Dogs("australianTerrier","rex",16);
		Dogs beagle = new Dogs("Beagle","Azor",20);
		
		Dogs [] weightUnsorted = new Dogs [] {afganHound,beagle,australianTerrier};
		Dogs [] expected = new Dogs [] {australianTerrier,beagle,afganHound};
		Dogs [] weightSorted = bubbleSort.sort(weightUnsorted);
		assertArrayEquals(expected,weightSorted);
	}
}
