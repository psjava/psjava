package org.psjava.ds.map;

import org.psjava.ds.Collection;

public interface Map<K, V> extends Collection<MapEntry<K, V>> {

	boolean containsKey(K key);

	V get(K key);

	V get(K key, V def);

	Iterable<V> values(); // TODO remove, use util.

	Iterable<K> keys(); // TODO remove, use util.
}