package org.psjava.algo.math;

import org.psjava.goods.GoodLongHash;

public class PairHash {
    public static int hash(int h1, int h2) {
        return GoodLongHash.hash((((long) h1) << 32) | h2);
    }

    private PairHash() {
    }
}
