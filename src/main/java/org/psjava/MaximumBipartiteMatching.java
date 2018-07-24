package org.psjava;

import org.psjava.algo.graph.bfs.BFSVisitor;
import org.psjava.algo.graph.dfs.DFSCore;
import org.psjava.algo.graph.dfs.DFSStatus;
import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.util.FilteredIterable;
import org.psjava.util.Pair;
import org.psjava.util.SingletonKeeper;
import org.psjava.util.VisitorStopper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// implementation : Hopcroft Karp algorithm. O(V*root(E))
public class MaximumBipartiteMatching {

    public static <V> MaximumBipartiteMatchingResult<V> calculate(BipartiteGraph<V> bg) {
        Map<V, Vertex<V>> vertex = new HashMap<>();
        for (V left : bg.getLeftVertices())
            vertex.put(left, new Vertex<>(left, Side.LEFT));
        for (V right : bg.getRightVertices())
            vertex.put(right, new Vertex<>(right, Side.RIGHT));

        Map<Vertex<V>, List<Edge<V>>> adj = new HashMap<>();
        vertex.values().forEach(it -> adj.put(it, new ArrayList<>()));
        for (BipartiteGraphEdge<V> e : bg.getEdges()) {
            EdgeStatus status = new EdgeStatus();
            Vertex<V> left = vertex.get(e.left);
            Vertex<V> right = vertex.get(e.right);
            adj.get(left).add(new Edge<>(left, right, status));
            adj.get(right).add(new Edge<>(right, left, status));
        }

        Collection<Vertex<V>> vertices = vertex.values();
        while (true) {
            Object bfsMark = new Object();
            Collection<Vertex<V>> bfsFinishes = bfs(vertices, adj::get, bfsMark);
            if (bfsFinishes.isEmpty())
                break;
            dfs(vertices, adj::get, bfsFinishes, bfsMark);
        }

        return constructResult(vertices, adj);
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

    private static <V> void dfs(Collection<Vertex<V>> vertices, AdjacencyList<Vertex<V>, Edge<V>> adj, Collection<Vertex<V>> bfsFinishes, Object bfsMark) {
        // uses only edges discovered in bfs step.
        AdjacencyList<Vertex<V>, Edge<V>> subAdj = EdgeFilteredSubAdjacencyList.wrap(adj, e -> e.status.bfsMark == bfsMark);

        vertices.forEach(v1 -> v1.dfsStatus = null);

        for (Vertex<V> start : bfsFinishes) {
            if (start.dfsStatus == null) {
                List<Edge<V>> path = new ArrayList<>();
                DFSCore.traverse(start, subAdj, e -> e.to, v -> v.dfsStatus, (v, status) -> v.dfsStatus = status, new DFSVisitorBase<Vertex<V>, Edge<V>>() {
                    @Override
                    public void onWalkDown(Edge<V> edge) {
                        path.add(edge);
                    }

                    @Override
                    public void onWalkUp(Edge<V> downedEdge) {
                        RemoveLast.removeLast(path);
                    }

                    @Override
                    public void onDiscovered(Vertex<V> v, int depth, VisitorStopper stopper) {
                        if (path.size() % 2 == 1 && v.free) {
                            path.forEach(e -> e.status.inMatch = !e.status.inMatch);
                            start.free = false;
                            v.free = false;
                            stopper.stop();
                        }
                    }
                });
            }
        }
    }

    private static <V> MaximumBipartiteMatchingResult<V> constructResult(Collection<Vertex<V>> vertices, Map<Vertex<V>, List<Edge<V>>> adj) {
        return new MaximumBipartiteMatchingResult<V>() {
            @Override
            public int getCount() {
                long nonFreeCount = vertices.stream().filter(v -> !v.free).count();
                return (int) (nonFreeCount / 2);
            }

            SingletonKeeper<Set<Pair<V, V>>> matchPairsKeeper = new SingletonKeeper<>(() -> adj.values().stream()
                    .flatMap(Collection::stream)
                    .filter(edge -> edge.from.side == Side.LEFT && edge.status.inMatch)
                    .map(edge -> Pair.create(edge.from.original, edge.to.original))
                    .collect(Collectors.toSet())
            );

            @Override
            public boolean isMatch(V left, V right) {
                return matchPairsKeeper.getInstance().contains(Pair.create(left, right));
            }
        };
    }

}
