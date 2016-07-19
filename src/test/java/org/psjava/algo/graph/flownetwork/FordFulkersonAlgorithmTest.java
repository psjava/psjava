package org.psjava.algo.graph.flownetwork;

import org.psjava.algo.graph.flownetwork.FordFulkersonAlgorithm;
import org.psjava.algo.graph.pathfinder.DFSPathFinder;

public class FordFulkersonAlgorithmTest extends MaximumFlowAlgorithmTestBase {
    public FordFulkersonAlgorithmTest() {
        super(FordFulkersonAlgorithm.getInstance(DFSPathFinder.getInstance()));
    }
}
