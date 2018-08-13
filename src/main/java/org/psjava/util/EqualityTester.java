package org.psjava.util;

// TODO use BiPredicate, remove this.
@Deprecated
public interface EqualityTester<T> {
    boolean areEqual(T o1, T o2);
}