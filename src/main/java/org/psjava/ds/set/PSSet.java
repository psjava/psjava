package org.psjava.ds.set;

import org.psjava.ds.PSCollection;

@Deprecated
public interface PSSet<T> extends PSCollection<T> {
    boolean contains(T v);
}