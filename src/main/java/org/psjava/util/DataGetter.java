package org.psjava.util;

public interface DataGetter<K, V> {
    V get(K v);
}