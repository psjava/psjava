package org.psjava.algo.sequence.search;

import org.psjava.ds.math.BooleanDefaultComparator;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;

public class BinarySearchLastFalse {

    public static <I> I search(IntegerDivisableNumberSystem<I> inputNumberSystem, Function<I, Boolean> falseToTrueFunction, I begin, I end, I def) {
        return BinarySearchLast.search(inputNumberSystem, falseToTrueFunction, BooleanDefaultComparator.getInstance(), begin, end, Boolean.FALSE, def);
    }

    private BinarySearchLastFalse() {
    }

}
