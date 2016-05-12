package org.psjava.algo;

import org.psjava.ds.array.AddToLastAll;
import org.psjava.ds.array.Array;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromIterable;
import org.psjava.goods.GoodSortingAlgorithm;
import org.psjava.util.IterableUsingStatusUpdater;
import org.psjava.util.Updater;

import java.util.Comparator;


public class PermutationWithRepetitionIterable {

	// SRM464-1-250 is a good problem to solve using this.

	public static <T> Iterable<Array<T>> create(Iterable<T> items, final Comparator<T> comparator) {
		MutableArray<T> initial = MutableArrayFromIterable.create(items);
		GoodSortingAlgorithm.getInstance().sort(initial, comparator);
		return IterableUsingStatusUpdater.create(initial, new Updater<Array<T>>() {
			@Override
			public Array<T> getUpdatedOrNull(Array<T> current) {
				DynamicArray<T> next = DynamicArray.create();
				AddToLastAll.add(next, current);
				if (!NextPermutation.step(next, comparator))
					return null;
				return next;
			}
		});
	}

}
