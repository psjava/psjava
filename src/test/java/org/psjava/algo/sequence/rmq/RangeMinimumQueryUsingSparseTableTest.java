package org.psjava.algo.sequence.rmq;

import org.psjava.algo.sequence.rmq.RangeMinimumQueryTestBase;
import org.psjava.algo.sequence.rmq.RangeMinimumQueryUsingSparseTable;

public class RangeMinimumQueryUsingSparseTableTest extends RangeMinimumQueryTestBase {

    protected RangeMinimumQuery getInstance() {
        return RangeMinimumQueryUsingSparseTable.getInstance();
    }

}
