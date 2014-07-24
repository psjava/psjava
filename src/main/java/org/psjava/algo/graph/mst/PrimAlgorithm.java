package org.psjava.algo.graph.mst;

import java.util.Comparator;

import org.psjava.algo.graph.NumberOfConnectedComponents;
import org.psjava.algo.graph.shortestpath.NullableDistanceCompare;
import org.psjava.ds.graph.AdjacencyList;
import org.psjava.ds.graph.AdjacencyListFromGraph;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.MutableGraph;
import org.psjava.ds.graph.OppositeInUndirectedEdge;
import org.psjava.ds.graph.UndirectedWeightedEdge;
import org.psjava.ds.heap.Heap;
import org.psjava.ds.heap.HeapFactory;
import org.psjava.ds.heap.HeapNode;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.util.AssertStatus;

public class PrimAlgorithm {

	public static MinimumSpanningTreeAlgorithm getInstance(final HeapFactory heapFactory, final MutableMapFactory mapFactory) {
		return new MinimumSpanningTreeAlgorithm() {
			@Override
			public <T, V, E extends UndirectedWeightedEdge<V, T>> Graph<V, E> calc(Graph<V, E> graph, final AddableNumberSystem<T> ns) {
				AssertStatus.assertTrue(NumberOfConnectedComponents.calc(graph) <= 1);
				MutableGraph<V, E> result = MutableGraph.create();
				if (graph.getVertices().size() == 0)
					return result;

				V start = graph.getVertices().iterator().next();
				final MutableMap<V, T> distance = mapFactory.create();
				MutableMap<V, E> previous = mapFactory.create();

				for (V v : graph.getVertices())
					distance.addOrReplace(v, null); // null means infinity
				distance.addOrReplace(start, ns.getZero());

				Heap<V> heap = heapFactory.create(new Comparator<V>() {
					@Override
					public int compare(V o1, V o2) {
						return NullableDistanceCompare.compare(ns, distance.get(o1), distance.get(o2));
					}
				});

				MutableMap<V, HeapNode<V>> nodes = mapFactory.create();
				for (V v : graph.getVertices())
					nodes.addOrReplace(v, heap.insert(v));

				AdjacencyList<V, E> adj = AdjacencyListFromGraph.createFromUndirected(graph);
				while (!heap.isEmpty()) {
					V current = heap.extractMinimum();
					if (previous.containsKey(current))
						result.addEdge(previous.get(current));
					for (E edge : adj.getEdges(current)) {
						V opposite = OppositeInUndirectedEdge.get(edge, current);
						HeapNode<V> node = nodes.get(opposite);
						if (node.isInHeap() && NullableDistanceCompare.compare(ns, distance.get(opposite), edge.weight()) > 0) {
							distance.addOrReplace(opposite, edge.weight());
							previous.addOrReplace(opposite, edge);
							node.decreaseKey(opposite);
						}
					}
				}
				return result;
			}
		};
	}

	private PrimAlgorithm() {
	}

}
