package org.psjava.ds.deque;

public interface Deque<T> {

    void addToFirst(T v);

    void addToLast(T e);

    T getFirst();

    T getLast();

    T removeFirst();

    T removeLast();

    boolean isEmpty();

    void clear();

}