package org.psjava.util;

// TODO rename? Acceptor
@Deprecated // use Predicate
public interface Filter<T> {
    boolean isAccepted(T v);
}
