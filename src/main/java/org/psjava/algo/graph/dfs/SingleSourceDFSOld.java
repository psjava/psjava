package org.psjava.algo.graph.dfs;

import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;

import java.util.HashMap;
import java.util.Map;

// TODO inline
@Deprecated
public class SingleSourceDFSOld {

    public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> adj, V start, DFSVisitor<V, E> visitor) {
        Map<V, DFSStatus> map = new HashMap<>();
        DFSCore.traverse(start, adj::getEdges, DirectedEdge::to, map::get, map::put, visitor);
    }

}
