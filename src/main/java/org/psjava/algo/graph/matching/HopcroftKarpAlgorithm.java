package org.psjava.algo.graph.matching;

import org.psjava.AdjacencyList;
import org.psjava.BFSCore;
import org.psjava.BFSStatus;
import org.psjava.EdgeFilteredSubAdjacencyList;
import org.psjava.RemoveLast;
import org.psjava.algo.graph.bfs.BFSVisitor;
import org.psjava.algo.graph.dfs.DFSCore;
import org.psjava.algo.graph.dfs.DFSStatus;
import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.ds.graph.BipartiteGraph;
import org.psjava.ds.graph.BipartiteGraphEdge;
import org.psjava.util.Filter;
import org.psjava.util.FilteredIterable;
import org.psjava.util.VisitorStopper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

// O(V*root(E))
public class HopcroftKarpAlgorithm {

    public static MaximumBipartiteMatchingAlgorithm getInstance() {
        return new MaximumBipartiteMatchingAlgorithm() {
            @Override
            public <V> int calc(BipartiteGraph<V> bg) {
                Map<V, Vertex<V>> vertex = new HashMap<>();
                for (V left : bg.getLeftVertices())
                    vertex.put(left, new Vertex<>(left, Side.LEFT));
                for (V right : bg.getRightVertices())
                    vertex.put(right, new Vertex<>(right, Side.RIGHT));

                Map<Vertex<V>, List<Edge<V>>> adj = new HashMap<>();
                vertex.values().forEach(it -> adj.put(it, new ArrayList<>()));
                for (BipartiteGraphEdge<V> e : bg.getEdges()) {
                    EdgeStatus status = new EdgeStatus();
                    Vertex<V> left = vertex.get(e.left());
                    Vertex<V> right = vertex.get(e.right());
                    adj.get(left).add(new Edge<>(left, right, status));
                    adj.get(right).add(new Edge<>(right, left, status));
                }

                Collection<Vertex<V>> vertices = vertex.values();
                while (true) {
                    Object bfsMark = new Object();
                    Collection<Vertex<V>> bfsFinishes = bfs(vertices, adj::get, bfsMark);
                    if (bfsFinishes.isEmpty())
                        break;
                    dfs(
                            vertices,
                            adj::get,
                            e -> e.to,
                            v -> v.dfsStatus,
                            (v, status) -> v.dfsStatus = status,
                            v -> v.free,
                            v -> v.free = false,
                            e -> e.status.inMatch = !e.status.inMatch,
                            bfsFinishes,
                            e -> e.status.bfsMark == bfsMark
                    );
                }
                long freeCount = vertices.stream().filter(v -> !v.free).count();
                return (int) (freeCount / 2);
            }
        };
    }

    private enum Side {
        LEFT, RIGHT
    }

    private static class Vertex<V> {
        final V original;
        final Side side;
        DFSStatus dfsStatus = null;
        BFSStatus bfsStatus = null;
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

    private static class Edge<V> {
        final Vertex<V> from, to;
        final EdgeStatus status;

        Edge(Vertex<V> from, Vertex<V> to, EdgeStatus status) {
            this.from = from;
            this.to = to;
            this.status = status;
        }
    }

    private static <V> Collection<Vertex<V>> bfs(Collection<Vertex<V>> vertices, AdjacencyList<Vertex<V>, Edge<V>> adj, final Object mark) {
        final List<Vertex<V>> finishes = new ArrayList<>();

        AdjacencyList<Vertex<V>, Edge<V>> subAdj = EdgeFilteredSubAdjacencyList.wrap(adj, edge -> {
            // to alternate matched and non-matched edges.
            if (edge.from.side == Side.LEFT)
                return !edge.status.inMatch;
            else
                return edge.status.inMatch;
        });

        Iterable<Vertex<V>> freeLeftVertexes = FilteredIterable.create(vertices, v -> (v.side == Side.LEFT) && v.free);

        vertices.forEach(v -> v.bfsStatus = BFSStatus.NOT_DISCOVERED);
        BFSCore.traverse(subAdj, e -> e.to, v -> v.bfsStatus, (v, s) -> v.bfsStatus = s, freeLeftVertexes, new BFSVisitor<Vertex<V>, Edge<V>>() {
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
