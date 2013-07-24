package org.psjava.algo.search;

import java.util.Comparator;

import org.psjava.javautil.ReversedComparator;
import org.psjava.math.ReflectionOnYAxis;
import org.psjava.math.calc.Decrease;
import org.psjava.math.calc.Increase;
import org.psjava.math.ns.AddInvert;
import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class BinarySearchLast {

	public static <I, O> I search(IntegerDivisableNumberSystem<I> inputNumberSystem, Function<I, O> f, Comparator<O> sortedOrder, I begin, I end, O target, I def) {
		IntegerDivisableNumberSystem<I> ns = inputNumberSystem;
		I newBegin = AddInvert.calc(ns, Decrease.calc(ns, end));
		I newEnd = Increase.calc(ns, AddInvert.calc(ns, begin));
		I subr = BinarySearchFirst.search(ns, ReflectionOnYAxis.create(ns, f), ReversedComparator.wrap(sortedOrder), newBegin, newEnd, target, null);
		if (subr != null)
			return AddInvert.calc(ns, subr);
		else
			return def;
	}

}
