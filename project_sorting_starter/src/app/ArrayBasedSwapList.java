package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class ArrayBasedSwapList<T> implements SwapList<T> {
	private final ArrayList<T> arrayList;
	private int swaps = 0;
	private int comparisons = 0;

	public ArrayBasedSwapList(T[] array) {
		arrayList = new ArrayList<T>(Arrays.asList(array));
	}

	public ArrayBasedSwapList(Collection<T> coll) {
		arrayList = new ArrayList<T>(coll);
	}

	@Override
	public int compare(int index1, int index2, Comparator<T> comparator) {
		comparisons++;
		return comparator.compare(arrayList.get(index1), arrayList.get(index2));
	}

	@Override
	public void swap(int index1, int index2) {
		swaps++;
		T temp = arrayList.get(index1);
		arrayList.set(index1, arrayList.get(index2));
		arrayList.set(index2, temp);
	}

	@Override
	public int size() {
		return arrayList.size();
	}

	// Returns true iff the list is sorted in ascending order according to the given comparator.
	@Override
	public boolean isSorted(Comparator<T> comparator) {
		//this loops runs through all the elements of the list
		for(int i = 1; i < arrayList.size(); i++){
			//compares the elements at index i-1 and i
			int j = comparator.compare(arrayList.get(i-1), arrayList.get(i));
			//if the element at index i-1 is more than the one at i, the method returns false and exits
			if(j > 0)
				return false;

		}
		//if all the elements are in ascending order, the method returns true
		return true;
	}

	public int getSwaps() {
		return swaps;
	}

	public int getComparisons() {
		return comparisons;
	}

	// Returns a whole-number percentage of elements sorted. Traverses the list once and tallys all
	// correct ordered consecutive pairs (ex: [1, 2] is correct but [2, 1] is not).  Then divides 
	// this by the number of comparisons completed.
	// Ex: [1, 2, 3, 4] returns 100 (3 correctly sorted pairs ( [1,2], [2,3], [3,4] ) divided by 3 total comparisons)
	// Ex: [4, 3, 2, 1] returns 0
	// Ex: [4, 1, 2, 3, 5] returns 75
	@Override
	public int scoreList(Comparator<T> comparator) {
		//this variable stores the the number of pairs that are sorted
		int sortComp = 0;
		//this loops runs through all elements of the list
		for(int i = 1; i < arrayList.size(); i++){
			//compares each pair of elements, eg, (0,1), (1,2) and so on
			int j = comparator.compare(arrayList.get(i-1), arrayList.get(i));
			//increments comparisons for each run of compare
			comparisons++;
			//if the element on index i-1 is less than the one on i, that means they are sorted
			//if they are, sortComp is incremented
			if(j < 0)
				sortComp++;
		}
		//returns the percentage of all the sorted pairs out of all the comparisons ran
		return ((sortComp*100)/comparisons);
	}
	
	@Override
	public String toString() {
		return arrayList.toString();
	}
}
