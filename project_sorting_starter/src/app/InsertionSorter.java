package app;

import java.util.Comparator;


public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
			if(list.isSorted(comparator))
				return list;

			int len = list.size();
			for (int i = 0; i < len - 1; i++){
				for(int j = i; j > 0 && list.compare(i-1, i, comparator) > 0; j--){
					list.swap(i-1, i);
				}
			}
		return list;

	}
}
