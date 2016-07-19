package org.psjava.goods;

import org.psjava.ds.HashSetFactory;
import org.psjava.ds.SetFactory;

public class GoodSetFactory {
    public static SetFactory getInstance() {
        return HashSetFactory.INSTANCE;
    }
}
