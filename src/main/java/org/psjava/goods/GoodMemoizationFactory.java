package org.psjava.goods;

import org.psjava.algo.math.optimization.MemoizationFactory;

public class GoodMemoizationFactory {

    public static MemoizationFactory getInstance() {
        return new MemoizationFactory(GoodMutableMapFactory.getInstance(), GoodMutableSetFactory.getInstance());
    }

    private GoodMemoizationFactory() {
    }

}
