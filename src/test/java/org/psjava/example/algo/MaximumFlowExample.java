package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.flownetwork.EdmondsKarpAlgorithm;
import org.psjava.algo.graph.flownetwork.FordFulkersonAlgorithm;
import org.psjava.algo.graph.flownetwork.MaximumFlowAlgorithm;
import org.psjava.algo.graph.flownetwork.MaximumFlowAlgorithmResult;
import org.psjava.algo.graph.pathfinder.DFSPathFinder;
import org.psjava.ds.graph.CapacityEdge;
import org.psjava.ds.graph.MutableCapacityGraph;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class MaximumFlowExample {
	@Test
	public void test() {
		// Construct a graph with capacities.

		MutableCapacityGraph<String, Integer> capacityGraph = MutableCapacityGraph.create();
		capacityGraph.insertVertex("A");
		capacityGraph.insertVertex("B");
		capacityGraph.insertVertex("C");
		capacityGraph.insertVertex("D");
		capacityGraph.addEdge("A", "B", 4);
		capacityGraph.addEdge("A", "C", 2);
		capacityGraph.addEdge("B", "C", 1);
		capacityGraph.addEdge("B", "D", 4);
		capacityGraph.addEdge("C", "D", 1);

		// Choose Algorithm, and run it.

		MaximumFlowAlgorithm algorithm = EdmondsKarpAlgorithm.getInstance();
		MaximumFlowAlgorithmResult<Integer, CapacityEdge<String, Integer>> result = algorithm.calc(capacityGraph, "A", "D", IntegerNumberSystem.getInstance());

		int maximumFlow = result.calcTotalFlow(); // must be 5

		// Also, you can obtain the flows in each edges by retrieved flow function.

		Function<CapacityEdge<String, Integer>, Integer> flowFunction = result.calcFlowFunction();
		for (CapacityEdge<String, Integer> e : capacityGraph.getEdges()) {
			flowFunction.get(e);
		}

		// There are several maximum flow algorithms.
		FordFulkersonAlgorithm.getInstance(DFSPathFinder.getInstance());
		EdmondsKarpAlgorithm.getInstance();

		Assert.assertEquals(5, maximumFlow);
	}
}
