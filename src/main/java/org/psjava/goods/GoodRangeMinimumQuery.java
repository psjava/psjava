package org.psjava.goods;

import org.psjava.algo.sequence.rmq.RangeMinimumQueryUsingSegmentTree;
import org.psjava.algo.sequence.rmq.RangeMinimumQuery;

public class GoodRangeMinimumQuery {

    public static RangeMinimumQuery getInstance() {
        return RangeMinimumQueryUsingSegmentTree.INSTANCE;
    }

}
