package org.psjava.ds.set;

public interface MutableSetFactory {
    <T> MutableSet<T> create();
}
