package org.psjava.algo.search;

import java.util.Comparator;

import org.psjava.javautil.ReversedComparator;
import org.psjava.math.BooleanDefaultComparator;
import org.psjava.math.Function;
import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class BinarySearchLastTrue {

	public static <I> I search(final IntegerDivisableNumberSystem<I> inputNumberSystem, Function<I, Boolean> trueToFalseOrderedFunction, I begin, I end, I def) {
		Comparator<Boolean> comp = ReversedComparator.wrap(BooleanDefaultComparator.getInstance());
		return BinarySearchLast.search(inputNumberSystem, trueToFalseOrderedFunction, comp, begin, end, Boolean.TRUE, def);
	}

}
