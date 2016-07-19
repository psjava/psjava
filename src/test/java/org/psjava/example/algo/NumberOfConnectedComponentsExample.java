package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.NumberOfConnectedComponents;
import org.psjava.ds.graph.MutableUndirectedUnweightedGraph;

public class NumberOfConnectedComponentsExample {
    @Test
    public void example() {
        MutableUndirectedUnweightedGraph<String> graph = MutableUndirectedUnweightedGraph.create();
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("D", "C");

        int number = NumberOfConnectedComponents.calc(graph); // must be 3. {A,B}, {C,D}, {E}

        Assert.assertEquals(3, number);
    }

}
