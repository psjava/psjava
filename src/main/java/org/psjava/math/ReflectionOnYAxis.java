package org.psjava.math;

import org.psjava.algo.search.Function;
import org.psjava.math.ns.AddInvert;
import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class ReflectionOnYAxis {

	public static <O, I> Function<I, O> create(final IntegerDivisableNumberSystem<I> inputNumberSystem, final Function<I, O> original) {
		return new Function<I, O>() {
			@Override
			public O get(I input) {
				return original.get(AddInvert.calc(inputNumberSystem, input));
			}
		};
	}

}
