package org.psjava.ds.set;

public interface DisjointSet<T> {
    void makeSet(T value);

    void union(T x, T y);

    T find(T x);
}