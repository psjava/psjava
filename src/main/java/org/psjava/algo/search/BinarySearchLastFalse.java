package org.psjava.algo.search;

import org.psjava.math.calc.Decrease;
import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class BinarySearchLastFalse {

	public static <K> K search(final IntegerDivisableNumberSystem<K> keyNumberSystem, K beginKey, K endKey, final Function<K, Boolean> nonDecreasingFunction, K def) {
		K firstTrueKey = BinarySearchFirstTrue.search(keyNumberSystem, beginKey, endKey, nonDecreasingFunction, endKey);
		if (firstTrueKey.equals(beginKey))
			return def;
		return Decrease.calc(keyNumberSystem, firstTrueKey);
	}

}
