package org.psjava.algo.search;

import org.psjava.math.BooleanDefaultComparator;
import org.psjava.math.Function;
import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class BinarySearchFirstTrue {

	public static <I> I search(IntegerDivisableNumberSystem<I> inputNumberSystem, Function<I, Boolean> falseToTrueFunction, I begin, I end, I def) {
		return BinarySearchFirst.search(inputNumberSystem, falseToTrueFunction, BooleanDefaultComparator.getInstance(), begin, end, Boolean.TRUE, def);
	}

}
