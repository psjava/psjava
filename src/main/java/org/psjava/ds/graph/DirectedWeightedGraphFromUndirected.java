package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.javautil.ConvertedDataIterable;
import org.psjava.javautil.DataConverter;
import org.psjava.javautil.MergedIterable;
import org.psjava.javautil.VarargsIterable;

public class DirectedWeightedGraphFromUndirected {

	public static <V, W> DirectedWeightedGraph<V, W> wrap(final UndirectedWeightedGraph<V, W> graph) {
		return new DirectedWeightedGraph<V, W>() {
			@Override
			public Collection<V> getVertices() {
				return graph.getVertices();
			}

			@SuppressWarnings("unchecked")
			@Override
			public Iterable<DirectedWeightedEdge<V, W>> getEdges() {
				return MergedIterable.wrap(VarargsIterable.create(ConvertedDataIterable.create(graph.getEdges(), new DataConverter<UndirectedWeightedEdge<V, W>, DirectedWeightedEdge<V, W>>() {
					@Override
					public DirectedWeightedEdge<V, W> convert(UndirectedWeightedEdge<V, W> original) {
						return DirectedWeightedEdgeFactory.create(original.v1(), original.v2(), original.weight());
					}
				}), ConvertedDataIterable.create(graph.getEdges(), new DataConverter<UndirectedWeightedEdge<V, W>, DirectedWeightedEdge<V, W>>() {
					@Override
					public DirectedWeightedEdge<V, W> convert(UndirectedWeightedEdge<V, W> original) {
						return DirectedWeightedEdgeFactory.create(original.v2(), original.v1(), original.weight());
					}
				})));
			}
		};
	}

}
