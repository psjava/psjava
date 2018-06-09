package org.psjava.ds.map;

import org.psjava.util.DataGetter;

public class DataGetterFromMap {

    public static <K, V> DataGetter<K, V> wrap(final PSMap<K, V> map) {
        return new DataGetter<K, V>() {
            @Override
            public V get(K k) {
                return map.get(k);
            }
        };
    }

    private DataGetterFromMap() {
    }

}
