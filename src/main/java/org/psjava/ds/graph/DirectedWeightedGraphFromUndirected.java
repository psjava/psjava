package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.javautil.ConvertedDataIterable;
import org.psjava.javautil.DataConverter;
import org.psjava.javautil.MergedIterable;
import org.psjava.javautil.VarargsIterable;

public class DirectedWeightedGraphFromUndirected {

	public static <V, W, E extends UndirectedWeightedEdge<V, W>> Graph<V, DirectedWeightedEdge<V, W>> wrap(final Graph<V, E> graph) {
		return new Graph<V, DirectedWeightedEdge<V, W>>() {
			@Override
			public Collection<V> getVertices() {
				return graph.getVertices();
			}

			@SuppressWarnings("unchecked")
			@Override
			public Iterable<DirectedWeightedEdge<V, W>> getEdges() {
				return MergedIterable.wrap(VarargsIterable.create(ConvertedDataIterable.create(graph.getEdges(), new DataConverter<E, DirectedWeightedEdge<V, W>>() {
					@Override
					public DirectedWeightedEdge<V, W> convert(E original) {
						return DirectedWeightedEdgeFactory.create(original.v1(), original.v2(), original.weight());
					}
				}), ConvertedDataIterable.create(graph.getEdges(), new DataConverter<E, DirectedWeightedEdge<V, W>>() {
					@Override
					public DirectedWeightedEdge<V, W> convert(E original) {
						return DirectedWeightedEdgeFactory.create(original.v2(), original.v1(), original.weight());
					}
				})));
			}
		};
	}

}
