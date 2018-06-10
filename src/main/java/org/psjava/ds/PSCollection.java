package org.psjava.ds;

@Deprecated
public interface PSCollection<T> extends Iterable<T> {
    int size();

    boolean isEmpty();
}
