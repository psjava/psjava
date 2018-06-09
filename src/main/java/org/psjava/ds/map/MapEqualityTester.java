package org.psjava.ds.map;

import org.psjava.ds.KeyValuePair;

public class MapEqualityTester {

    public static <K, V> boolean areEqual(PSMap<K, V> m1, PSMap<K, V> m2) {
        if (m1.size() != m2.size())
            return false;
        for (KeyValuePair<K, V> pair : m1) {
            K key1 = pair.getKey();
            V value1 = pair.getValue();
            if (!m2.containsKey(key1))
                return false;
            return MapValueEqualityTester.areEqual(value1, m2.get(key1));
        }
        return true;
    }

    private MapEqualityTester() {
    }

}
