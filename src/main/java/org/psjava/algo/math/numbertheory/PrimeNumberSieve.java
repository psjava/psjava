package org.psjava.algo.math.numbertheory;

import org.psjava.ds.array.PSArray;

public interface PrimeNumberSieve {
    PSArray<Integer> calcList(int max);
}