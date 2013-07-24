package org.psjava.ds.set;

import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;


public class DisjointSetForest {
	
	// see http://en.wikipedia.org/wiki/Disjoint-set_data_structure
	
	public static <T> DisjointSet<T> create(MutableMapFactory mapFactory) {
		final MutableMap<T, NodeInfo<T>> infoMap = mapFactory.create();
		return new DisjointSet<T>() {

			@Override
			public void makeSet(T value) {
				infoMap.put(value, new NodeInfo<T>(value, 0));
			}

			@Override
			public void union(T x, T y) {
				T xrep = find(x);
				T yrep = find(y);
				if (xrep == yrep)
					return;
				NodeInfo<T> xinfo = infoMap.get(xrep);
				NodeInfo<T> yinfo = infoMap.get(yrep);
				if (xinfo.rank > yinfo.rank) {
					yinfo.parent = xrep;
				} else {
					xinfo.parent = yrep;
					if (xinfo.rank == yinfo.rank)
						yinfo.rank++;
				}
			}

			@Override
			public T find(T x) {
				NodeInfo<T> info = infoMap.get(x);
				if (!info.parent.equals(x))
					info.parent = find(info.parent);
				return info.parent;
			}

		};
	}
	
	private static class NodeInfo<T> {
		T parent;
		int rank;

		public NodeInfo(T p, int rank) {
			this.parent = p;
			this.rank = rank;
		}
	}

	private DisjointSetForest() {
	}
	
}
