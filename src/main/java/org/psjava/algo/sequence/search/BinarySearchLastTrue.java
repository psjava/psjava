package org.psjava.algo.sequence.search;

import java.util.Comparator;
import java.util.function.Function;

import org.psjava.ds.math.BooleanDefaultComparator;
import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;
import org.psjava.util.ReversedComparator;

public class BinarySearchLastTrue {

    public static <I> I search(final IntegerDivisableNumberSystem<I> inputNumberSystem, Function<I, Boolean> trueToFalseOrderedFunction, I begin, I end, I def) {
        Comparator<Boolean> comp = ReversedComparator.wrap(BooleanDefaultComparator.getInstance());
        return BinarySearchLast.search(inputNumberSystem, trueToFalseOrderedFunction, comp, begin, end, Boolean.TRUE, def);
    }

    private BinarySearchLastTrue() {
    }
}
