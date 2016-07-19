package org.psjava.algo.math.optimization;

public interface MemoizationFunction<I, O> {
    O get(I input, Memoization<I, O> memo);
}
