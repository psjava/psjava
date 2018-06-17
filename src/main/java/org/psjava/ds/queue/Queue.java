package org.psjava.ds.queue;

@Deprecated
public interface Queue<T> {
    void enque(T v);

    T deque();

    boolean isEmpty();
}
