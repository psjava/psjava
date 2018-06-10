package org.psjava.ds.stack;

@Deprecated
public interface PSStack<T> {
    void push(T v);

    T pop();

    T top();

    boolean isEmpty();
}
