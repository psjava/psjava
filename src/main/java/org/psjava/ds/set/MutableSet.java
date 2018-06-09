package org.psjava.ds.set;

@Deprecated
public interface MutableSet<T> extends PSSet<T> {
    void clear();

    void add(T v);

    void addIfAbsent(T v);

    void remove(T v);

    void removeIfExist(T v);
}
