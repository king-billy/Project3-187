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
			for (int i = 1; i < len; i++){
				for(int j = i; j > 0 && list.compare(j, j-1, comparator) < 0; j--){
					list.swap(j-1, j);
				}
			}
		return list;

	}
}
