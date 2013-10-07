package org.psjava.algo.graph.dfs;

import org.psjava.ds.graph.AdjacencyList;
import org.psjava.ds.graph.AdjacencyListFromGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.map.MutableMap;

public class MultiSourceDFS {

	// TODO inline
	public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> graph, Iterable<V> visitOrder, DFSVisitor<V, E> visitor) {
		traverse(AdjacencyListFromGraph.create(graph), visitOrder, visitor);
	}

	public static <V, E extends DirectedEdge<V>> void traverse(AdjacencyList<V, E> adj, Iterable<V> visitOrder, DFSVisitor<V, E> visitor) {
		MutableMap<V, DFSStatus> status = DFSCore.createInitialStatus(adj.getVertices());
		for (V v : visitOrder) 
			if (status.get(v) == DFSStatus.NOT_DISCOVERED)
				DFSCore.traverse(adj, status, v, visitor);
	}

}
