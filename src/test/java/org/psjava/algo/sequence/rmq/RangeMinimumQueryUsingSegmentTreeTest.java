package org.psjava.algo.sequence.rmq;

import org.psjava.algo.sequence.rmq.RangeMinimumQueryTestBase;
import org.psjava.algo.sequence.rmq.RangeMinimumQuery;
import org.psjava.goods.GoodSegmentTreeFactory;

public class RangeMinimumQueryUsingSegmentTreeTest extends RangeMinimumQueryTestBase {

	protected RangeMinimumQuery getInstance() {
		return RangeMinimumQueryUsingSegmentTree.getInstance(GoodSegmentTreeFactory.getInstance());
	}

}
