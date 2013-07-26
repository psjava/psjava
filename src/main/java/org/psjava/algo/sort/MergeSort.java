package org.psjava.algo.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.psjava.ds.array.MutableArray;

public class MergeSort {

	public static Sort getInstance() {
		return new Sort() {
			@Override
			public <T> void sort(MutableArray<T> a, Comparator<T> comparator) {
				List<T> temp = new ArrayList<T>(a.size());
				for (int i = 0; i < a.size(); i++)
					temp.add(null);
				mergeSort(a, 0, a.size() - 1, comparator, temp);
			}

			private <T> void mergeSort(MutableArray<T> list, int start, int end, Comparator<T> comparator, List<T> temp) {
				if (start < end) {
					int mid = (start + end) / 2;
					mergeSort(list, start, mid, comparator, temp);
					mergeSort(list, mid + 1, end, comparator, temp);

					int p = 0;
					int p1 = start;
					int p2 = mid + 1;
					while (p1 <= mid && p2 <= end)
						if (comparator.compare(list.get(p1), list.get(p2)) < 0)
							temp.set(p++, list.get(p1++));
						else
							temp.set(p++, list.get(p2++));

					while (p1 <= mid)
						temp.set(p++, list.get(p1++));
					while (p2 <= end)
						temp.set(p++, list.get(p2++));
					for (int i = start; i <= end; i++)
						list.set(i, temp.get(i - start));
				}
			}
		};
	}
}