package org.psjava.ds.map;

public interface MutableMapFactory {
    <K, V> MutableMap<K, V> create();
}
