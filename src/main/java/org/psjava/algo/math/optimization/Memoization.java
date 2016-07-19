package org.psjava.algo.math.optimization;

public interface Memoization<I, O> {
    O get(I input);
}