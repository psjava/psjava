package org.psjava.util;

import java.util.function.Predicate;

public class EqualityFilter {

    public static <T> Predicate<T> create(final T target) {
        return target::equals;
    }

}
