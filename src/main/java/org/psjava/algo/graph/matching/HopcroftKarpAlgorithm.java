package org.psjava.algo.graph.matching;

import org.psjava.AdjacencyList;
import org.psjava.EdgeFilteredSubAdjacencyList;
import org.psjava.RemoveLast;
import org.psjava.algo.graph.bfs.BFS;
import org.psjava.algo.graph.bfs.BFSVisitor;
import org.psjava.algo.graph.dfs.DFSCore;
import org.psjava.algo.graph.dfs.DFSStatus;
import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.ds.graph.BipartiteGraph;
import org.psjava.ds.graph.BipartiteGraphEdge;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.EdgeFilteredSubGraph;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.SimpleDirectedGraph;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.ValuesInMap;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.util.Filter;
import org.psjava.util.FilteredIterable;
import org.psjava.util.VisitorStopper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

// O(V*root(E))
public class HopcroftKarpAlgorithm {

    public static MaximumBipartiteMatchingAlgorithm getInstance() {
        return new MaximumBipartiteMatchingAlgorithm() {
            @Override
            public <V> int calc(BipartiteGraph<V> bg) {
                Graph<Vertex<V>, Edge<V>> graph = wrapAsGraph(bg);
                while (true) {
                    Object bfsMark = new Object();
                    Collection<Vertex<V>> bfsFinishes = bfs(graph, bfsMark);
                    if (bfsFinishes.isEmpty())
                        break;
                    dfs(
                            graph.getVertices(),
                            graph::getEdges,
                            Edge::to,
                            v -> v.dfsStatus,
                            (v, status) -> v.dfsStatus = status,
                            v -> v.free,
                            v -> v.free = false,
                            e -> e.status.inMatch = !e.status.inMatch,
                            bfsFinishes,
                            e -> e.status.bfsMark == bfsMark
                    );
                }
                int count = 0;
                for (Vertex<V> v : graph.getVertices())
                    for (Edge<V> e : graph.getEdges(v))
                        if (e.status.inMatch)
                            count++;
                return count / 2;
            }
        };
    }

    private enum Side {
        LEFT, RIGHT
    }

    private static class Vertex<V> {
        V original;
        DFSStatus dfsStatus = null;
        Side side;
        boolean free = true;

        Vertex(V original, Side side) {
            this.original = original;
            this.side = side;
        }
    }

    private static class EdgeStatus {
        boolean inMatch = false;
        Object bfsMark = null;
    }

    private static class Edge<V> implements DirectedEdge<Vertex<V>> {
        final Vertex<V> from, to;
        final EdgeStatus status;

        Edge(Vertex<V> from, Vertex<V> to, EdgeStatus status) {
            this.from = from;
            this.to = to;
            this.status = status;
        }

        @Override
        public Vertex<V> from() {
            return from;
        }

        @Override
        public Vertex<V> to() {
            return to;
        }

    }

    private static <V> Graph<Vertex<V>, Edge<V>> wrapAsGraph(BipartiteGraph<V> bg) {
        MutableMap<V, Vertex<V>> vertex = GoodMutableMapFactory.getInstance().create();
        for (V v : bg.getLeftVertices())
            vertex.add(v, new Vertex<V>(v, Side.LEFT));
        for (V v : bg.getRightVertices())
            vertex.add(v, new Vertex<V>(v, Side.RIGHT));
        SimpleDirectedGraph<Vertex<V>, Edge<V>> graph = SimpleDirectedGraph.create();
        for (Vertex<V> v : ValuesInMap.get(vertex))
            graph.insertVertex(v);
        for (BipartiteGraphEdge<V> e : bg.getEdges()) {
            EdgeStatus status = new EdgeStatus();
            graph.addEdge(new Edge<V>(vertex.get(e.left()), vertex.get(e.right()), status));
            graph.addEdge(new Edge<V>(vertex.get(e.right()), vertex.get(e.left()), status));
        }
        return graph;
    }

    private static <V> Collection<Vertex<V>> bfs(final Graph<Vertex<V>, Edge<V>> adj, final Object mark) {
        final List<Vertex<V>> finishes = new ArrayList<>();

        Graph<Vertex<V>, Edge<V>> subGraph = EdgeFilteredSubGraph.wrap(adj, edge -> {
            // to alternate matched and non-matched edges.
            if (edge.from.side == Side.LEFT)
                return !edge.status.inMatch;
            else
                return edge.status.inMatch;
        });

        Iterable<Vertex<V>> freeLeftVertexes = FilteredIterable.create(adj.getVertices(), v -> (v.side == Side.LEFT) && v.free);

        BFS.traverse(subGraph, freeLeftVertexes, new BFSVisitor<Vertex<V>, Edge<V>>() {
            int finishDepth = -1;

            @Override
            public void onDiscover(Vertex<V> vertex, int depth, VisitorStopper stopper) {
                if (finishDepth == -1 || depth <= finishDepth) {
                    if (vertex.side == Side.RIGHT && vertex.free) {
                        finishDepth = depth;
                        finishes.add(vertex);
                    }
                } else {
                    stopper.stop();
                }
            }

            @Override
            public void onWalk(Edge<V> e) {
                e.status.bfsMark = mark;
            }

        });
        return finishes;
    }

    private static <V, E> void dfs(
            Collection<V> vertices,
            AdjacencyList<V, E> adj,
            Function<E, V> destination,
            Function<V, DFSStatus> getDfsStatus,
            BiConsumer<V, DFSStatus> setDfsStatus,
            Function<V, Boolean> isFree,
            Consumer<V> unFree,
            Consumer<E> toggleMatch,
            Collection<V> bfsFinishes,
            Filter<E> wasInBfs
    ) {

        // uses only edges discovered in bfs step.
        AdjacencyList<V, E> subAdj = EdgeFilteredSubAdjacencyList.wrap(adj, wasInBfs);

        vertices.forEach(v -> setDfsStatus.accept(v, null));

        for (V start : bfsFinishes) {
            if (getDfsStatus.apply(start) == null) {
                List<E> path = new ArrayList<>();
                DFSCore.traverse(start, subAdj, destination, getDfsStatus, setDfsStatus, new DFSVisitorBase<V, E>() {
                    @Override
                    public void onWalkDown(E edge) {
                        path.add(edge);
                    }

                    @Override
                    public void onWalkUp(E downedEdge) {
                        RemoveLast.removeLast(path);
                    }

                    @Override
                    public void onDiscovered(V v, int depth, VisitorStopper stopper) {
                        if (path.size() % 2 == 1 && isFree.apply(v)) {
                            path.forEach(toggleMatch);
                            unFree.accept(start);
                            unFree.accept(v);
                            stopper.stop();
                        }
                    }
                });
            }
        }
    }

}
