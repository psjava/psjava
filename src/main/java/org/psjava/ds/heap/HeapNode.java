package org.psjava.ds.heap;

public interface HeapNode<T> {
	T getKey();
	void decreaseKey(T newKey);
	void delete();
}
