package org.psjava.formula;

import org.psjava.ds.math.BinaryOperator;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class Sum {
	public static <T> T calc(final AddableNumberSystem<T> ns, Iterable<T> iterable) {
		return Accumulate.calc(iterable, ns.getZero(), new BinaryOperator<T>() {
			@Override
			public T calc(T a, T b) {
				return ns.add(a, b);
			}
		});
	}
}
