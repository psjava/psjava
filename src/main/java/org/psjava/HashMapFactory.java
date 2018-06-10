package org.psjava;

import org.psjava.ds.map.MapFactory;

import java.util.HashMap;

public class HashMapFactory {

    public static <V> MapFactory<V> create() {
        return HashMap::new;
    }
}
