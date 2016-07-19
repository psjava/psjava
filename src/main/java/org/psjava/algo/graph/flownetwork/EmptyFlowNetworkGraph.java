package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.graph.AllEdgeInGraph;
import org.psjava.ds.graph.CapacityEdge;
import org.psjava.ds.graph.FlowNetworkEdge;
import org.psjava.ds.graph.FlowStatus;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.SimpleDirectedGraph;
import org.psjava.ds.graph.SimpleFlowNetworkEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class EmptyFlowNetworkGraph {

    public static <V, T, E extends CapacityEdge<V, T>> Graph<V, FlowNetworkEdge<V, T, E>> create(Graph<V, E> capacityGraph, AddableNumberSystem<T> ns) {
        // TODO extract as a util. when move min cost max flow algorithms.
        SimpleDirectedGraph<V, FlowNetworkEdge<V, T, E>> g = SimpleDirectedGraph.create();
        for (V v : capacityGraph.getVertices())
            g.insertVertex(v);
        for (E edge : AllEdgeInGraph.wrap(capacityGraph)) {
            FlowNetworkEdge<V, T, E> original = SimpleFlowNetworkEdge.create(edge.from(), edge.to(), new FlowStatus<T>(edge.capacity(), ns.getZero()), edge);
            FlowNetworkEdge<V, T, E> skewSymmetry = SimpleFlowNetworkEdge.create(edge.to(), edge.from(), new FlowStatus<T>(ns.getZero(), ns.getZero()), null);
            original.setOpposite(skewSymmetry);
            skewSymmetry.setOpposite(original);
            g.addEdge(original);
            g.addEdge(skewSymmetry);
        }
        return g;
    }

    private EmptyFlowNetworkGraph() {
    }

}
