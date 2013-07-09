package org.psjava.algo.search;


import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class IndexBinarySearcher {

	public static <T> IndexBinarySearcherResult<T> searchFirstTrue(IntegerDivisableNumberSystem<T> ns, IndexBinarySearcherData<T> data, T left, T right) {
		boolean found = false;
		T index = left;
		T one = ns.getOne();
		T two = ns.add(one, one);
		while (ns.compare(left, right) <= 0) {
			T mid = ns.integerDivide(ns.add(left, right), two);
			if(data.get(mid)) {
				found = true;
				index = mid;
				right = ns.subtract(mid, one);
			} else {
				left = ns.add(mid, one);
			}
		}
		return createResult(found, index);
	}

	private static <T> IndexBinarySearcherResult<T> createResult(final boolean exist, final T lastIndex) {
		return new IndexBinarySearcherResult<T>() {
			@Override
			public T getIndex() {
				if (!exist)
					throw new IllegalArgumentException("result is not exist");
				return lastIndex;
			}

			@Override
			public boolean isExist() {
				return exist;
			}
		};
	}

}
