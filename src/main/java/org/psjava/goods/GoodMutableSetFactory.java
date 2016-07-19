package org.psjava.goods;

import org.psjava.ds.set.JavaHashSetFactory;
import org.psjava.ds.set.MutableSetFactory;

@Deprecated
public class GoodMutableSetFactory {
    public static MutableSetFactory getInstance() {
        return JavaHashSetFactory.getInstance();
    }

    private GoodMutableSetFactory() {
    }
}
