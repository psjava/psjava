package org.psjava.algo.sequence.rmq;

public class OnDemandRangeMinimumQueryTest extends RangeMinimumQueryTestBase {

    @Override
    protected RangeMinimumQuery getInstance() {
        return OnDemandRangeMinimumQuery.getInstance();
    }

}
