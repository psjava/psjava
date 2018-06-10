package org.psjava.ds.map;

/**
 * Not allows null key.
 * but allows null value.
 */
@Deprecated
public interface MutableMap<K, V> extends PSMap<K, V> {
    void clear();

    void add(K key, V nullableValue);

    void replace(K key, V nullableValue);

    void addOrReplace(K key, V nullableValue);

    void remove(K key);
}
