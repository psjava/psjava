package org.psjava.algo.search;

public class InvertedFunction {

	public static <X> Function<X, Boolean> wrap(final Function<X, Boolean> f) {
		return new Function<X, Boolean>() {
			@Override
			public Boolean get(X x) {
				return !f.get(x);
			}
		};
	}

}
