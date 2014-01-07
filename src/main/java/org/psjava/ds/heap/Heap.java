package org.psjava.ds.heap;

public interface Heap<T> {
	/**
	 * min-heap
	 */
	T getMinimum();

	HeapNode<T> insert(T v);

	T extractMinimum();

	boolean isEmpty();
}
