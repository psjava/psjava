package org.psjava.ds;

@Deprecated
public interface Collection<T> extends Iterable<T> {
    int size();

    boolean isEmpty();
}
