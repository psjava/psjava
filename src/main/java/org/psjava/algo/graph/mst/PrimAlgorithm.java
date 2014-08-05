package org.psjava.algo.graph.mst;

import java.util.Comparator;

import org.psjava.algo.graph.NumberOfConnectedComponents;
import org.psjava.algo.graph.shortestpath.NullableDistanceCompare;
import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.graph.Graph;
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
			public <T, V, E extends UndirectedWeightedEdge<V, T>> Collection< E> calc(Graph<V, E> graph, final AddableNumberSystem<T> ns) {
				AssertStatus.assertTrue(NumberOfConnectedComponents.calc(graph) <= 1);
				DynamicArray<E> result = DynamicArray.create();
				if (graph.getVertices().size() == 0)
					return result;

				V start = graph.getVertices().iterator().next();
				final MutableMap<V, T> distance = mapFactory.create();
				MutableMap<V, E> previous = mapFactory.create();

				for (V v : graph.getVertices())
					distance.add(v, null); // null means infinity
				distance.replace(start, ns.getZero());

				Heap<V> heap = heapFactory.create(new Comparator<V>() {
					@Override
					public int compare(V o1, V o2) {
						return NullableDistanceCompare.compare(ns, distance.get(o1), distance.get(o2));
					}
				});

				MutableMap<V, HeapNode<V>> nodes = mapFactory.create();
				for (V v : graph.getVertices())
					nodes.add(v, heap.insert(v));

				while (!heap.isEmpty()) {
					V current = heap.extractMinimum();
					if (previous.containsKey(current))
						result.addToLast(previous.get(current));
					for (E edge : graph.getEdges(current)) {
						V opposite = OppositeInUndirectedEdge.get(edge, current);
						HeapNode<V> node = nodes.get(opposite);
						if (node.isInHeap() && NullableDistanceCompare.compare(ns, distance.get(opposite), edge.weight()) > 0) {
							distance.replace(opposite, edge.weight());
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
