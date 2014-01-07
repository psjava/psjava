package org.psjava.ds.heap;

import java.util.Comparator;

import org.psjava.util.EmptyIterable;

public class BinaryHeapFactory implements HeapFactory {

	@Override
	public <T> Heap<T> create(Comparator<T> comparator) {
		return new BinaryHeap<T>(new EmptyIterable<T>(), comparator);
	}

}
