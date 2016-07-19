package org.psjava.goods;

import org.psjava.ds.map.JavaHashMapFactory;
import org.psjava.ds.map.MutableMapFactory;

public class GoodMutableMapFactory {

    public static MutableMapFactory getInstance() {
        return JavaHashMapFactory.getInstance();
    }

    private GoodMutableMapFactory() {
    }

}
