package org.psjava.util;

import org.psjava.goods.GoodIntHash;

public class OrderFreeIterableHash {

    public static <T> int hash(Iterable<T> iterable) {
        int r = 0;
        for (T v : iterable)
            r ^= GoodIntHash.hash(v.hashCode());
        return r;
    }

    private OrderFreeIterableHash() {
    }

}
