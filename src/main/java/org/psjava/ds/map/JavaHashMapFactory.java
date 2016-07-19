package org.psjava.ds.map;

import java.util.HashMap;

public class JavaHashMapFactory {

    public static MutableMapFactory getInstance() {
        return new MutableMapFactory() {
            @Override
            public <K, V> MutableMap<K, V> create() {
                return MutableMapUsingJavaMap.wrap(new HashMap<K, V>());
            }
        };
    }

    private JavaHashMapFactory() {
    }
}
