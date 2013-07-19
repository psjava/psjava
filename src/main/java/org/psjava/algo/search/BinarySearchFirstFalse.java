package org.psjava.algo.search;

import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class BinarySearchFirstFalse {

	public static <K> K search(final IntegerDivisableNumberSystem<K> keyNumberSystem, K beginKey, K endKey, final Function<K, Boolean> nonIncreasingFunction, K def) {
		return BinarySearchFirstTrue.search(keyNumberSystem, beginKey, endKey, InvertedFunction.wrap(nonIncreasingFunction), def);
	}

}
