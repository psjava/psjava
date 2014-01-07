package org.psjava.ds.map;

import org.psjava.ds.Collection;
import org.psjava.ds.KeyValuePair;

public interface Map<K, V> extends Collection<KeyValuePair<K, V>> {

	boolean containsKey(K key);

	V get(K key);

	V get(K key, V def);
}