package org.psjava.ds.set;

import org.psjava.goods.GoodMutableSetFactory;

@Deprecated
public class SetFromIterable {

    public static <T> PSSet<T> create(Iterable<T> iterable) {
        MutableSet<T> r = GoodMutableSetFactory.getInstance().create();
        InsertAllToSet.insertAll(r, iterable);
        return r;
    }

    private SetFromIterable() {
    }

}
