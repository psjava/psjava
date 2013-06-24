package org.psjava.ds.map;

import org.psjava.ds.Collection;

public interface MutableMap<K, V> extends Collection<MutableEntry<K, V>> {
	// TODO introduce normal map interface
	void clear(); 
	void put(K key, V value);
	void remove(K key);
	boolean containsKey(K key);
	V get(K key);
	V get(K key, V def);
	Iterable<V> values();
	Iterable<K> keys();
}
