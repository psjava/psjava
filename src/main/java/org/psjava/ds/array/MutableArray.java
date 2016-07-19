package org.psjava.ds.array;

public interface MutableArray<T> extends Array<T> {
    void set(int index, T value);
}
