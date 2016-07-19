package org.psjava.ds.set;

import org.psjava.ds.Collection;

@Deprecated
public interface Set<T> extends Collection<T> {
    boolean contains(T v);
}