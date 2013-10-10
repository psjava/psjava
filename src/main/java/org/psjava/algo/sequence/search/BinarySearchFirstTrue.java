package org.psjava.algo.sequence.search;

import org.psjava.ds.math.BooleanDefaultComparator;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;

public class BinarySearchFirstTrue {

	public static <I> I search(IntegerDivisableNumberSystem<I> inputNumberSystem, Function<I, Boolean> falseToTrueFunction, I begin, I end, I def) {
		return BinarySearchFirst.search(inputNumberSystem, falseToTrueFunction, BooleanDefaultComparator.getInstance(), begin, end, Boolean.TRUE, def);
	}

}
