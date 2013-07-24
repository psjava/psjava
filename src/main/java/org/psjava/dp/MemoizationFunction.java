package org.psjava.dp;

public interface MemoizationFunction<I, O> {
	O get(I input, Memoization<I, O> memo);
}
