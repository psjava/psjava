package org.psjava.ds.array;

import org.psjava.ds.PSCollection;

@Deprecated
public interface PSArray<T> extends PSCollection<T> {
    T get(int index);
}
