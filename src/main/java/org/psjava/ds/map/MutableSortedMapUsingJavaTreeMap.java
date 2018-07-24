package org.psjava.ds.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

import org.psjava.ds.KeyValuePair;
import org.psjava.util.Assertion;

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
                Assertion.ensure(original.containsKey(key));
                return original.get(key);
            }

            @Override
            public V getOrNull(K key) {
                return original.get(key);
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
            public void add(K key, V value) {
                Assertion.ensure(!original.containsKey(key));
                original.put(key, value);
            }

            @Override
            public void replace(K key, V value) {
                Assertion.ensure(original.containsKey(key));
                original.put(key, value);
            }

            @Override
            public void addOrReplace(K key, V value) {
                Assertion.ensureNotNull(value, "value cannot be a null");
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
