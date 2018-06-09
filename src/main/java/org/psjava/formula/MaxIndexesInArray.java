package org.psjava.formula;

import org.psjava.ds.array.PSArray;
import org.psjava.util.Filter;
import org.psjava.util.FilteredIterable;
import org.psjava.util.ZeroTo;

import java.util.Comparator;

public class MaxIndexesInArray {

    public static <T> Iterable<Integer> get(final PSArray<T> array, final Comparator<T> comparator) {
        final T max = MaxInIterable.max(array, comparator);
        return FilteredIterable.create(ZeroTo.get(array.size()), new Filter<Integer>() {
            @Override
            public boolean isAccepted(Integer index) {
                return comparator.compare(array.get(index), max) == 0;
            }
        });
    }
}
