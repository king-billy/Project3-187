package app;

import java.util.Comparator;


public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		quickSort(0, list.size() - 1);
		
		return list;
	}

	public int partition(int low, int high){
		int i = low - 1;
		for(int j = low; j <= high - 1;j++){
			if(list.compare(j, high, comparator) < 0){
				i++;
				list.swap(i, j);
			}
		}
		list.swap(i+1, high);
		return (i+1);
	}

	public void quickSort(int low, int high){
		if(low < high){
			int pi = partition(low, high);
			quickSort(low, pi-1);
			quickSort(pi+1, high);
		}
	}
}