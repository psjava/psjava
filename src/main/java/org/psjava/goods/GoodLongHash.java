package org.psjava.goods;

import org.psjava.algo.math.ThomasWangHash64Bit;

public class GoodLongHash {

    public static int hash(long v) {
        return ThomasWangHash64Bit.hash(v);
    }

}
