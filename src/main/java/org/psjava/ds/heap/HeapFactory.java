package org.psjava.ds.heap;

import java.util.Comparator;

public interface HeapFactory {
    <T> Heap<T> create(Comparator<T> comparator);

}
