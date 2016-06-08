package org.psjava.util;

import org.psjava.ds.math.Function;

import java.util.Map;

public class GetOrInitial {

    public static <K, V> V getOrInitial(Map<K, V> map, K key, Function<K, V> initialValueFactory) {
        V existOrNull = map.get(key);
        if (existOrNull == null) {
            V init = initialValueFactory.get(key);
            map.put(key, init);
            return init;
        } else {
            return existOrNull;
        }
    }

}
