package org.psjava.algo.math;

import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.AddInvert;
import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;

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
