package org.psjava.algo.search;

import java.util.Comparator;

import org.psjava.javautil.ReversedComparator;
import org.psjava.math.BooleanDefaultComparator;
import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class BinarySearchFirstFalse {

	public static <K> K search(IntegerDivisableNumberSystem<K> keyNumberSystem, Function<K, Boolean> trueToFalseFunction, K begin, K end, K def) {
		Comparator<Boolean> rcomp = ReversedComparator.wrap(BooleanDefaultComparator.getInstance());
		return BinarySearchFirst.search(keyNumberSystem, trueToFalseFunction, rcomp, begin, end, Boolean.FALSE, def);
	}

}
