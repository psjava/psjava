package org.psjava.algo.sequence.rmq;

public class OnDemandRMQTest extends RangeMinimumQueryTestBase {

	@Override
	protected RangeMinimumQuery getInstance() {
		return OnDemandRMQ.getInstance();
	}

}
