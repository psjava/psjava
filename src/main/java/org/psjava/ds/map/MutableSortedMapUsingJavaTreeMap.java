package org.psjava.ds.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

import org.psjava.ds.KeyValuePair;
import org.psjava.util.AssertStatus;

public class MutableSortedMapUsingJavaTreeMap {

	public static <K, V> MutableSortedMap<K, V> create(Comparator<K> comp) {
		final TreeMap<K, V> original = new TreeMap<K, V>();
		return new MutableSortedMap<K, V>() {
			@Override
			public void clear() {
				original.clear();
			}

			@Override
			public boolean containsKey(K key) {
				return original.containsKey(key);
			}

			@Override
			public V get(K key) {
				V r = original.get(key);
				AssertStatus.assertNotNull(r, "no value for the key");
				return r;
			}

			@Override
			public V get(K key, V def) {
				V r = original.get(key);
				if (r == null)
					return def;
				return r;
			}

			@Override
			public boolean isEmpty() {
				return original.isEmpty();
			}

			@Override
			public Iterator<KeyValuePair<K, V>> iterator() {
				return MapIteratorFromJavaMap.create(original);
			}

			@Override
			public void put(K key, V value) {
				AssertStatus.assertNotNull(value, "value cannot be a null");
				original.put(key, value);
			}

			@Override
			public void remove(K key) {
				original.remove(key);
			}

			@Override
			public int size() {
				return original.size();
			}
		};
	}

	private MutableSortedMapUsingJavaTreeMap() {
	}

}
