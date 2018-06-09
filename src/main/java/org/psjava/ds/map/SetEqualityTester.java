package org.psjava.ds.map;

import org.psjava.ds.set.PSSet;

public class SetEqualityTester {

    public static <V> boolean areEqual(PSSet<V> m1, PSSet<V> m2) {
        if (m1.size() != m2.size())
            return false;
        for (V v : m1)
            if (!m2.contains(v))
                return false;
        return true;
    }

    private SetEqualityTester() {
    }

}
