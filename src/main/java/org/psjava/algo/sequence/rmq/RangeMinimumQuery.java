package org.psjava.algo.sequence.rmq;

import java.util.Comparator;


import org.psjava.ds.array.PSArray;

public interface RangeMinimumQuery {
    <T> RangeMinimumQuerySession preprocess(PSArray<T> a, Comparator<T> comp);
}
