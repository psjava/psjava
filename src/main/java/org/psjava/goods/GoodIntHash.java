package org.psjava.goods;

import org.psjava.algo.math.ThomasWangHash32Bit;

public class GoodIntHash {

    public static int hash(int v) {
        return ThomasWangHash32Bit.hash(v);
    }

    private GoodIntHash() {
    }

}
