package org.psjava.math;


public class Accumulate {

	public static <T> T calc(Iterable<T> values, T init, BinaryOperator<T> op) {
		T r = init;
		for(T v : values) 
			r = op.calc(r, v);
		return r;
	}

}
