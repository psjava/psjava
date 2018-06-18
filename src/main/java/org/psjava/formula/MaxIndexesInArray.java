package org.psjava.formula;

import org.psjava.ds.array.PSArray;
import org.psjava.util.FilteredIterable;
import org.psjava.util.ZeroTo;

import java.util.Comparator;
import java.util.function.Predicate;

public class MaxIndexesInArray {

    public static <T> Iterable<Integer> get(final PSArray<T> array, final Comparator<T> comparator) {
        final T max = MaxInIterable.max(array, comparator);
        return FilteredIterable.create(ZeroTo.get(array.size()), new Predicate<Integer>() {
            @Override
            public boolean test(Integer index) {
                return comparator.compare(array.get(index), max) == 0;
            }
        });
    }
}
