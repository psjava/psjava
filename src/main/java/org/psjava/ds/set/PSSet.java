package org.psjava.ds.set;

import org.psjava.ds.Collection;

@Deprecated
public interface PSSet<T> extends Collection<T> {
    boolean contains(T v);
}