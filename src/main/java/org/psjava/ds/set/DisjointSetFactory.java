package org.psjava.ds.set;

public interface DisjointSetFactory {
    <T> DisjointSet<T> create();
}
