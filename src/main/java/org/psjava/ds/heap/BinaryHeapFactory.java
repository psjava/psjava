package org.psjava.ds.heap;

import java.util.Comparator;

import org.psjava.util.EmptyIterable;

// TODO introduce static factory method
public class BinaryHeapFactory implements HeapFactory {

	@Override
	public <T> Heap<T> create(Comparator<T> comparator) {
		return new BinaryHeap<T>(new EmptyIterable<T>(), comparator);
	}

}
