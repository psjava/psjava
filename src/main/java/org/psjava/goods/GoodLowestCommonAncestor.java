package org.psjava.goods;

import org.psjava.algo.graph.LowestCommonAncestor;

public class GoodLowestCommonAncestor {

	public static LowestCommonAncestor getInstrance() {
		return new LowestCommonAncestor(GoodRangeMinimumQuery.getInstance(), GoodMutableMapFactory.getInstance());
	}

	private GoodLowestCommonAncestor() {
	}

}
