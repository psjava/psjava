package org.psjava.ds.map;

public interface MutableMap<K, V> extends Map<K, V> {
	void clear();

	void put(K key, V nullableValue);

	void remove(K key);
}
