package org.psjava.algo.graph.flownetwork;

import org.psjava.algo.graph.pathfinder.BFSPathFinder;

public class EdmondsKarpAlgorithm {

    public static MaximumFlowAlgorithm getInstance() {
        // Edmonds–Karp algorithm is just one of specializations of Ford–Fulkerson algorithm.
        return FordFulkersonAlgorithm.getInstance(BFSPathFinder.getInstance());
    }

    private EdmondsKarpAlgorithm() {
    }

}
