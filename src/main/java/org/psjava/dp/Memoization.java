package org.psjava.dp;

public interface Memoization<I, O> {
	O get(I input);
}