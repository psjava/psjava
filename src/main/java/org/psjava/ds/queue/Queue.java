package org.psjava.ds.queue;

public interface Queue<T> {
    void enque(T v);

    T deque();

    boolean isEmpty();
}
