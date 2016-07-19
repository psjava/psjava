package org.psjava.ds.map;

public class PutAllWithSameValue {

    public static <K, V> void put(MutableMap<K, V> map, V value, K... keys) {
        for (K key : keys)
            map.addOrReplace(key, value);
    }

    private PutAllWithSameValue() {
    }

}
