package org.psjava.ds;

import org.psjava.util.EqualityFilter;
import org.psjava.util.FilteredIterable;
import org.psjava.util.SizeOfIterable;

public class OccurrenceCounter {

    public static <T> int get(Iterable<T> items, T target) {
        return SizeOfIterable.getSize(FilteredIterable.create(items, EqualityFilter.create(target)));
    }

}
