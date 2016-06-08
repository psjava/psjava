package org.psjava.util;

public class EqualityFilter {

    public static <T> Filter<T> create(final T target) {
        return new Filter<T>() {
            @Override
            public boolean isAccepted(T v) {
                return target.equals(v);
            }
        };
    }

}
