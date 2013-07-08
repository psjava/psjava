package org.psjava.ds.set;

import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;


public class DisjointSet<T> {
	
	// implementation is the disjoint set forests

	private class NodeInfo {
		T parent;
		int rank;
		public NodeInfo(T p, int rank) {
			this.parent = p;
			this.rank = rank;
		}
	}
	
	private final MutableMap<T, NodeInfo> infoMap = GoodMutableMapFactory.getInstance().create();
	
	public void makeSet(T value) {
		infoMap.put(value, new NodeInfo(value, 0));
	}
	
	public void union(T x, T y) {
		T xrep = find(x);
		T yrep = find(y);
		if (xrep == yrep)
			return;
		NodeInfo xinfo = infoMap.get(xrep);
		NodeInfo yinfo = infoMap.get(yrep);
		if(xinfo.rank > yinfo.rank) {
			yinfo.parent = xrep;
		} else {
			xinfo.parent = yrep;
			if(xinfo.rank == yinfo.rank)
				yinfo.rank ++;
		}
	}
	
	public T find(T x) {
		NodeInfo info = infoMap.get(x);
		if(!info.parent.equals(x))
			info.parent = find(info.parent);
		return info.parent;
	}
	
}
