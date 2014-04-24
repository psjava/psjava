package org.psjava.goods;

import org.psjava.algo.sequence.rmq.RMQUsingSegmentTree;
import org.psjava.algo.sequence.rmq.RangeMinimumQuery;

public class GoodRangeMinimumQuery {

	public static RangeMinimumQuery getInstance() {
		return RMQUsingSegmentTree.getInstance(GoodSegmentTreeFactory.getInstance());
	}

}
