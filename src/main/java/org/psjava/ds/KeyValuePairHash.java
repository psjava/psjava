package org.psjava.ds;

import org.psjava.algo.math.PairHash;

public class KeyValuePairHash {
    public static <K, V> int hash(KeyValuePair<K, V> pair) {
        if (pair.getValue() == null)
            return pair.getKey().hashCode();
        return PairHash.hash(pair.getKey().hashCode(), pair.getValue().hashCode());
    }

    private KeyValuePairHash() {
    }

}
