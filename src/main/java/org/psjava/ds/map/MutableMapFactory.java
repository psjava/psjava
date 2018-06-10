package org.psjava.ds.map;

@Deprecated
public interface MutableMapFactory {
    <K, V> MutableMap<K, V> create();
}
