package org.psjava.goods;

import org.psjava.algo.graph.LowestCommonAncestorAlgorithm;

public class GoodLowestCommonAncestorAlgorithm {

    public static LowestCommonAncestorAlgorithm getInstrance() {
        return new LowestCommonAncestorAlgorithm(GoodRangeMinimumQuery.getInstance(), GoodMutableMapFactory.getInstance());
    }

    private GoodLowestCommonAncestorAlgorithm() {
    }

}
