package org.psjava.ds.array;

public interface MutableArray<T> extends PSArray<T> {
    void set(int index, T value);
}
