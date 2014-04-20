package org.psjava.algo.sequence.rmq;

import org.psjava.algo.sequence.rmq.RangeMinimumQueryTestBase;
import org.psjava.algo.sequence.rmq.SparseTableRMQ;

public class SparseTableRMQTest extends RangeMinimumQueryTestBase {

	protected RangeMinimumQuery getInstance() {
		return new SparseTableRMQ();
	}

}
