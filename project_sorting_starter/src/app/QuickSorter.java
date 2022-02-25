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

	public int partition(int low, int high){
		//index of the pivot point
		int piv = (high + low) / 2;
		//this is the last index of the sorted sub-list
		int partInd = low - 1;
		for (int i = low; i <= high; i++){
			if(i!=piv){
				if(list.compare(i, piv, comparator) < 0){
					partInd++;
					if(i!=partInd){
						list.swap(i, partInd);
						if(partInd==piv){
							piv = i;
						}
					}
				}
			}
		}
		list.swap(piv, partInd+1);
		return partInd + 1;
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