package org.psjava.util;

import java.util.function.Predicate;

public class FilteredIterable {

    public static <T> Iterable<T> create(final Iterable<? extends T> original, final Predicate<T> filter) {
        return IterableUsingIteratorFactory.create(() -> FilteredIterator.create(original.iterator(), filter));
    }

}