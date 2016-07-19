package org.psjava.ds.map;

import org.psjava.ds.set.Set;

public class SetEqualityTester {

    public static <V> boolean areEqual(Set<V> m1, Set<V> m2) {
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
