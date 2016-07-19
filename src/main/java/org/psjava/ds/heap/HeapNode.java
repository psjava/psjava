package org.psjava.ds.heap;

public interface HeapNode<T> {
    T getKey();

    boolean isInHeap();

    void decreaseKey(T newKey);

    void delete();
}
