package org.psjava.math;

import org.psjava.math.ns.AddableNumberSystem;

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
