package app;

import java.util.Comparator;


public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {

		//checks if the list is already sorted or not
		if (list.isSorted(comparator))
			return list;
		//calls quicksort of the list from index 0 to the last index
		quickSort(0, list.size() - 1);
		//this method returns the list as an output
		return list;
	}
	
	//This function takes the last element of the list as pivot
	//It places the pivot element in its right position and then puts
	//all smaller elements to its left and all greater elements to its right
	public int partition(int low, int high){
		//index of smaller element
		int i = low - 1;
		for(int j = low; j <= high - 1;j++){
			//if current element is smaller than the pivot
			if(list.compare(j, high, comparator) < 0){
				//increments the index of smaller element
				i++;
				list.swap(i, j);
			}
		}
		list.swap(i+1, high);
		return (i+1);
	}

	//this method implements the quick sort function
	public void quickSort(int low, int high){
		if(low < high){
			//this is the partitioning index
			int part = partition(low, high);
			//recursively sorts the left and right hand lists from the partitioning index
			quickSort(low, part-1);
			quickSort(part+1, high);
		}
	}
}