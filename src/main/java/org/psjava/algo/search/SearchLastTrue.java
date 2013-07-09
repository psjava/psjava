package org.psjava.algo.search;

import org.psjava.math.ns.AddInvert;
import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class SearchLastTrue {

	public static <T> IndexBinarySearcherResult<T> search(final IntegerDivisableNumberSystem<T> ns, T start, T end, final IndexBinarySearcherData<T> data) {
		final IndexBinarySearcherResult<T> subr = IndexBinarySearcher.searchFirstTrue(ns, new IndexBinarySearcherData<T>() {
			@Override
			public boolean get(T index) {
				return data.get(AddInvert.calc(ns, index));
			}			
		}, AddInvert.calc(ns, end), AddInvert.calc(ns, start));
		return new IndexBinarySearcherResult<T>() {
			@Override
			public T getIndex() {
				return AddInvert.calc(ns, subr.getIndex());
			}

			@Override
			public boolean isExist() {
				return subr.isExist();
			}
		};
	}

}
