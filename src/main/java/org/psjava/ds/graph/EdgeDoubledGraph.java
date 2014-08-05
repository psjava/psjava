package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.util.ConvertedDataIterable;
import org.psjava.util.DataConverter;
import org.psjava.util.MergedIterable;
import org.psjava.util.VarargsIterable;

public class EdgeDoubledGraph {

	@Deprecated
	public static <V, W, E1, E2> OldGraph<V, E2> wrap(final OldGraph<V, E1> original, final DataConverter<E1, E2> direction1Converter, final DataConverter<E1, E2> direction2Converter) {
		return new OldGraph<V, E2>() {
			@Override
			public Collection<V> getVertices() {
				return original.getVertices();
			}

			@SuppressWarnings("unchecked")
			@Override
			public Iterable<E2> getEdges() {
				return MergedIterable.wrap(VarargsIterable.create(ConvertedDataIterable.create(original.getEdges(), direction1Converter),
						ConvertedDataIterable.create(original.getEdges(), direction2Converter)));
			}

			@Override
			public String toString() {
				return GraphToString.toString(this);
			}
		};
	}

	public static <V, W, E1, E2> Graph<V, E2> wrap(final Graph<V, E1> original, final DataConverter<E1, E2> direction1Converter, final DataConverter<E1, E2> direction2Converter) {
		return new Graph<V, E2>() {
			@Override
			public Collection<V> getVertices() {
				return original.getVertices();
			}

			@SuppressWarnings("unchecked")
			@Override
			public Iterable<E2> getEdges(V v) {
				return MergedIterable.wrap(VarargsIterable.create(ConvertedDataIterable.create(original.getEdges(v), direction1Converter),
					ConvertedDataIterable.create(original.getEdges(v), direction2Converter)));
			}

			@Override
			public String toString() {
				return GraphToString.toString(this);
			}
		};
	}

	private EdgeDoubledGraph() {
	}

}
