package org.psjava.ds.deque;

@Deprecated
public interface PSDeque<T> {

    void addToFirst(T v);

    void addToLast(T e);

    T getFirst();

    T getLast();

    T removeFirst();

    T removeLast();

    boolean isEmpty();

    void clear();

}