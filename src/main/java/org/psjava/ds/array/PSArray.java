package org.psjava.ds.array;

import org.psjava.ds.Collection;

@Deprecated
public interface PSArray<T> extends Collection<T> {
    T get(int index);
}
