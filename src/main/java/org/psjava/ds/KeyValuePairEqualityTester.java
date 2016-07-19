package org.psjava.ds;

import org.psjava.ds.map.MapValueEqualityTester;

public class KeyValuePairEqualityTester {

    public static <K, V> boolean are(KeyValuePair<K, V> o1, KeyValuePair<K, V> o2) {
        return o1.getKey().equals(o2.getKey()) && MapValueEqualityTester.areEqual(o1.getValue(), o2.getValue());
    }

    private KeyValuePairEqualityTester() {
    }

}
