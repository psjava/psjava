package org.psjava.goods;

import org.psjava.algo.graph.LowestCommonAncestor;
import org.psjava.algo.sequence.rmq.RMQUsingSegmentTree;

public class GoodLowestCommonAncestor {

	public static LowestCommonAncestor getInstrance() {
		return new LowestCommonAncestor(RMQUsingSegmentTree.getInstance(GoodSegmentTreeFactory.getInstance()), GoodMutableMapFactory.getInstance());
	}

	private GoodLowestCommonAncestor() {
	}

}
