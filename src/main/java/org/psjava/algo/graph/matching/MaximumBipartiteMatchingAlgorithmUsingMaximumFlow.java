package org.psjava.algo.graph.matching;

import org.psjava.algo.graph.flownetwork.MaximumFlowAlgorithm;
import org.psjava.ds.graph.AllEdgeInGraph;
import org.psjava.ds.graph.BipartiteGraph;
import org.psjava.ds.graph.BipartiteGraphEdge;
import org.psjava.ds.graph.CapacityEdge;
import org.psjava.ds.graph.MutableCapacityGraph;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodMutableMapFactory;

public class MaximumBipartiteMatchingAlgorithmUsingMaximumFlow {

	public static MaximumBipartiteMatchingAlgorithm getInstance(final MaximumFlowAlgorithm maxFlow) {
		return new MaximumBipartiteMatchingAlgorithm() {
			@Override
			public <V> MaximumBipartiteMatchingResult<V> calc(BipartiteGraph<V> graph) {
				Object start = new Object();
				Object end = new Object();

				MutableCapacityGraph<Object, Integer> augmented = MutableCapacityGraph.create();
				augmented.insertVertex(start);
				augmented.insertVertex(end);
				for(Object v : graph.getLeftVertices()) {
					augmented.insertVertex(v);
					augmented.addEdge(start, v, 1);
				}
				for(Object v : graph.getRightVertices()) {
					augmented.insertVertex(v);
					augmented.addEdge(v, end, 1);
				}
				for(BipartiteGraphEdge<V> edge : graph.getEdges())
					augmented.addEdge(edge.left(), edge.right(), 1);

				Function<CapacityEdge<Object, Integer>, Integer> flow = maxFlow.calc(augmented, start, end, IntegerNumberSystem.getInstance()).calcFlowFunction();

				final MutableMap<Object, Object> match = GoodMutableMapFactory.getInstance().create();
				for (CapacityEdge<Object, Integer> edge : AllEdgeInGraph.wrap(augmented)) {
					if (flow.get(edge) == 1) {
						if (edge.from() != start && edge.to() != end) {
							match.add(edge.from(), edge.to());
							match.add(edge.to(), edge.from());
						}
					}
				}

				return new MaximumBipartiteMatchingResult<V>() {
					@Override
					public V getMatchedVertex(V v) {
						return (V)match.get(v);
					}

					@Override
					public int getMaxMatchCount() {
						return match.size() / 2;
					}

					@Override
					public boolean hasMatch(Object from) {
						return match.containsKey(from);
					}
				};
			}
		};
	}

}
