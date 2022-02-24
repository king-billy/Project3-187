package app;

import java.util.Comparator;


public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
			//len stores the length of the list
			int len = list.size();
			//insertion sort algorithm
			//the first loop runs from the index 1 to the last index
			for (int i = 1; i < len; i++){
				//the second loop checks if the element at index j - 1 is greater than the one at index j
				//it loops until j is greater than 0
				for(int j = i; j > 0 && list.compare(j, j-1, comparator) < 0; j--){
					//if it is greater, it swaps them
					list.swap(j-1, j);
				}
			}
		//this method returns the list as the output
		return list;

	}
}
