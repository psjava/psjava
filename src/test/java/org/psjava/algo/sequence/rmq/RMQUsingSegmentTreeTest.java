package org.psjava.algo.sequence.rmq;

import org.psjava.algo.sequence.rmq.RangeMinimumQueryTestBase;
import org.psjava.algo.sequence.rmq.RangeMinimumQuery;
import org.psjava.goods.GoodSegmentTreeFactory;

public class RMQUsingSegmentTreeTest extends RangeMinimumQueryTestBase {

	protected RangeMinimumQuery getInstance() {
		return RMQUsingSegmentTree.getInstance(GoodSegmentTreeFactory.getInstance());
	}

}
