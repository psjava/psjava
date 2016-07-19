package org.psjava.goods;

import org.psjava.ds.stack.StackFactory;
import org.psjava.ds.stack.StackFactoryUsingDynamicArray;

public class GoodStackFactory {

    private static final StackFactory INSTANCE = StackFactoryUsingDynamicArray.getInstance();

    public static StackFactory getInstance() {
        return INSTANCE;
    }

    private GoodStackFactory() {
    }

}
