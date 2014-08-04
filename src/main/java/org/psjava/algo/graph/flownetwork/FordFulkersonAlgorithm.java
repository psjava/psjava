package org.psjava.algo.graph.flownetwork;

import org.psjava.algo.graph.pathfinder.PathFinder;
import org.psjava.ds.Collection;
import org.psjava.ds.graph.AdjacencyList;
import org.psjava.ds.graph.AdjacencyListFromGraph;
import org.psjava.ds.graph.CapacityEdge;
import org.psjava.ds.graph.FlowNetworkEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class FordFulkersonAlgorithm {

	public static MaximumFlowAlgorithm getInstance(final PathFinder pathFinder) {
		return new MaximumFlowAlgorithm() {
			@Override
			public <V, F, E extends CapacityEdge<V, F>> MaximumFlowAlgorithmResult<F, E> calc(Graph<V, E> capacityGraph, V start, V end, AddableNumberSystem<F> ns) {
				AdjacencyList<V, FlowNetworkEdge<V, F, E>> flowNetwork = AdjacencyListFromGraph.createFromDirected(EmptyFlowNetworkGraph.create(capacityGraph, ns));
				while (true) {
					AdjacencyList<V, FlowNetworkEdge<V, F, E>> residualNetwork = ResidualNetworkAdjacencyList.wrap(flowNetwork, ns);
					Collection<FlowNetworkEdge<V, F, E>> augmentingPath = pathFinder.find(residualNetwork, start, end, null);
					if (augmentingPath == null || augmentingPath.size() == 0)
						break;
					F min = MinimumResidualOnPath.find(augmentingPath, ns);
					FlowAdjustOnPath.adjust(augmentingPath, min, ns);
				}
				return MaximumFlowAlgorithmResultFactory.create(flowNetwork, start, ns);
			}
		};
	}

	private FordFulkersonAlgorithm() {
	}
}
