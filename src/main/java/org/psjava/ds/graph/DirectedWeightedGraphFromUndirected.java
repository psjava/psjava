package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.javautil.ConvertedDataIterable;
import org.psjava.javautil.DataConverter;
import org.psjava.javautil.MergedIterable;
import org.psjava.javautil.VarargsIterable;

public class DirectedWeightedGraphFromUndirected {

	public static <W> DirectedWeightedGraph<W> wrap(final UndirectedWeightedGraph<W> graph) {
		return new DirectedWeightedGraph<W>() {
			@Override
			public Collection<Object> getVertices() {
				return graph.getVertices();
			}

			@SuppressWarnings("unchecked")
			@Override
			public Iterable<DirectedWeightedEdge<W>> getEdges() {
				return MergedIterable.wrap(VarargsIterable.create(ConvertedDataIterable.create(graph.getEdges(), new DataConverter<UndirectedWeightedEdge<W>, DirectedWeightedEdge<W>>() {
					@Override
					public DirectedWeightedEdge<W> convert(UndirectedWeightedEdge<W> original) {
						return DirectedWeightedEdgeFactory.create(original.v1(), original.v2(), original.weight());
					}
				}), ConvertedDataIterable.create(graph.getEdges(), new DataConverter<UndirectedWeightedEdge<W>, DirectedWeightedEdge<W>>() {
					@Override
					public DirectedWeightedEdge<W> convert(UndirectedWeightedEdge<W> original) {
						return DirectedWeightedEdgeFactory.create(original.v2(), original.v1(), original.weight());
					}
				})));
			}
		};
	}

}
