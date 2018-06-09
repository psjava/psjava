package org.psjava.ds.map;

import org.psjava.ds.Collection;
import org.psjava.ds.KeyValuePair;

@Deprecated
public interface PSMap<K, V> extends Collection<KeyValuePair<K, V>> {

    boolean containsKey(K key);

    V get(K key);

    V getOrNull(K key);
}