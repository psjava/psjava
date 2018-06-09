package org.psjava.ds.map;

import org.psjava.ds.KeyValuePair;
import org.psjava.util.ConvertedIterable;
import org.psjava.util.Converter;

public class ValuesInMap {
    public static <K, V> Iterable<V> get(PSMap<K, V> map) {
        return ConvertedIterable.create(map, new Converter<KeyValuePair<K, V>, V>() {
            @Override
            public V convert(KeyValuePair<K, V> pair) {
                return pair.getValue();
            }
        });
    }

    private ValuesInMap() {
    }
}
