package org.psjava.ds.map;

public interface MutableEntry<K, V> {
	// TODO introduce normal Entry interface.
	K getKey();
	V getValue();
	void setValue(V v);
}
