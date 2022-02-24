package app;

import java.util.Comparator;


public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO sort
			int len = list.size();
			for (int i = 0; i < len - 2; i++){
				int comp = list.compare(i, i+1, comparator);
				if(comp > 0){
					list.swap(i, i+1);
				}
			}
		return list;

	}
}
