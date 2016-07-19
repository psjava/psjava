package org.psjava.ds.heap;

/**
 * min-heap
 */
public interface Heap<T> {
    T getMinimum();

    HeapNode<T> insert(T v);

    T extractMinimum();

    boolean isEmpty();
}
