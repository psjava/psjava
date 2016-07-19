package org.psjava.util;

// TODO rename? Acceptor
public interface Filter<T> {
    boolean isAccepted(T v);
}
