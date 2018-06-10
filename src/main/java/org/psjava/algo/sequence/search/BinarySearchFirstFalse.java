package org.psjava.algo.sequence.search;

import java.util.Comparator;
import java.util.function.Function;

import org.psjava.ds.math.BooleanDefaultComparator;
import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;
import org.psjava.util.ReversedComparator;

public class BinarySearchFirstFalse {

    public static <K> K search(IntegerDivisableNumberSystem<K> keyNumberSystem, Function<K, Boolean> trueToFalseFunction, K begin, K end, K def) {
        Comparator<Boolean> rcomp = ReversedComparator.wrap(BooleanDefaultComparator.getInstance());
        return BinarySearchFirst.search(keyNumberSystem, trueToFalseFunction, rcomp, begin, end, Boolean.FALSE, def);
    }

    private BinarySearchFirstFalse() {
    }

}
