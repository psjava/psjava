package org.psjava.ds.heap;

import java.util.Comparator;

import org.psjava.util.EmptyIterable;

public class BinaryHeapFactory {

    public static HeapFactory getInstance() {
        return new HeapFactory() {
            @Override
            public <T> Heap<T> create(Comparator<T> comparator) {
                return new BinaryHeap<T>(new EmptyIterable<T>(), comparator);
            }
        };
    }

    private BinaryHeapFactory() {
    }
}
