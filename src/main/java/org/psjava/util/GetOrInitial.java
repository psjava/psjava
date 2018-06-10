package org.psjava.util;

import java.util.Map;
import java.util.function.Function;

public class GetOrInitial {

    public static <K, V> V getOrInitial(Map<K, V> map, K key, Function<K, V> initialValueFactory) {
        V existOrNull = map.get(key);
        if (existOrNull == null) {
            V init = initialValueFactory.apply(key);
            map.put(key, init);
            return init;
        } else {
            return existOrNull;
        }
    }

}
