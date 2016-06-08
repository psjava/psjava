package org.psjava.ds;

import org.psjava.ds.map.MutableMap;

public class AddToMapWithSameValue {

    public static <K, V> void add(MutableMap<K, V> map, Iterable<K> keys, V value) {
        for (K key : keys)
            map.add(key, value);
    }

}