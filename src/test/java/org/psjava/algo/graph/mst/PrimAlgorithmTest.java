package org.psjava.algo.graph.mst;

import org.psjava.algo.graph.mst.MinimumSpanningTreeAlgorithmTestBase;
import org.psjava.algo.graph.mst.PrimAlgorithm;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.goods.GoodMutableMapFactory;

public class PrimAlgorithmTest extends MinimumSpanningTreeAlgorithmTestBase {

	public MinimumSpanningTreeAlgorithm getInstance() {
		return PrimAlgorithm.getInstance(new BinaryHeapFactory(), GoodMutableMapFactory.getInstance());
	}

}
