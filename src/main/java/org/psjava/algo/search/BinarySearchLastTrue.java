package org.psjava.algo.search;

import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class BinarySearchLastTrue {

	public static <K> K search(final IntegerDivisableNumberSystem<K> keyNumberSystem, K beginKey, K endKey, final Function<K, Boolean> nonIncreasingFunction, K def) {
		return BinarySearchLastFalse.search(keyNumberSystem, beginKey, endKey, new Function<K, Boolean>() {
			@Override
			public Boolean get(K x) {
				return !nonIncreasingFunction.get(x);
			}
		}, def);
	}

}
