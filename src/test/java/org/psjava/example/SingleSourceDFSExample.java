package org.psjava.example;

import org.psjava.UnweightedGraph;
import org.psjava.SingleSourceDFS;

public class SingleSourceDFSExample {

    public static void main(String[] args) {

        // Let's prepare a simple graph.

        UnweightedGraph<String> graph = new UnweightedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("C", "A");

        // traverse and handle searching events.

        SingleSourceDFS.traverse(
                graph,
                "A",
                vertex -> System.out.println("discover " + vertex),
                vertex -> System.out.println("finish " + vertex)
        );

    }
}
