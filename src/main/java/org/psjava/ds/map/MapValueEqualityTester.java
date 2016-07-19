package org.psjava.ds.map;

public class MapValueEqualityTester {

    public static <V> boolean areEqual(V valueOrNull1, V valueOrNull2) {
        if (valueOrNull1 == null) {
            if (valueOrNull2 != null)
                return false;
        } else {
            if (!valueOrNull1.equals(valueOrNull2))
                return false;
        }
        return true;
    }

    private MapValueEqualityTester() {
    }

}
