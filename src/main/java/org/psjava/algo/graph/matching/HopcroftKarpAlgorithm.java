package org.psjava.algo.graph.matching;

import org.psjava.algo.graph.bfs.BFS;
import org.psjava.algo.graph.bfs.BFSVisitor;
import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.MultiSourceDFS;
import org.psjava.ds.PSCollection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.FirstInArray;
import org.psjava.ds.array.LastInArray;
import org.psjava.ds.graph.EdgeFilteredSubGraph;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.SimpleDirectedGraph;
import org.psjava.ds.graph.BipartiteGraph;
import org.psjava.ds.graph.BipartiteGraphEdge;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.ValuesInMap;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.util.FilteredIterable;
import org.psjava.util.VisitorStopper;
import org.psjava.util.ZeroTo;

/**
 * O(V*root(E))
 */

public class HopcroftKarpAlgorithm {

    public static MaximumBipartiteMatchingAlgorithm getInstance() {
        return new MaximumBipartiteMatchingAlgorithm() {
            @Override
            public <V> MaximumBipartiteMatchingResult<V> calc(BipartiteGraph<V> bg) {
                Graph<Vertex<V>, Edge<V>> adj = wrapAsGraph(bg);
                while (true) {
                    Object bfsMark = new Object();
                    PSCollection<Vertex<V>> bfsFinishes = bfs(adj, bfsMark);
                    if (bfsFinishes.isEmpty())
                        break;
                    dfs(adj, bfsFinishes, bfsMark);
                }
                return createResult(adj);
            }

        };
    }

    private static enum Side {
        LEFT, RIGHT
    }

    private static class Vertex<V> {
        V original;
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

    private static <V> PSCollection<Vertex<V>> bfs(final Graph<Vertex<V>, Edge<V>> adj, final Object mark) {
        final DynamicArray<Vertex<V>> finishes = DynamicArray.create();

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
                        finishes.addToLast(vertex);
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

    private static <V> void dfs(final Graph<Vertex<V>, Edge<V>> adj, final PSCollection<Vertex<V>> bfsFinishes, final Object bfsMark) {
        // uses only edges discovered in bfs step.
        Graph<Vertex<V>, Edge<V>> subGraph = EdgeFilteredSubGraph.wrap(adj, edge -> edge.status.bfsMark == bfsMark);

        MultiSourceDFS.traverse(subGraph, bfsFinishes, new DFSVisitorBase<Vertex<V>, Edge<V>>() {
            DynamicArray<Edge<V>> path = DynamicArray.create();

            @Override
            public void onWalkDown(Edge<V> edge) {
                path.addToLast(edge);
            }

            @Override
            public void onWalkUp(Edge<V> downedEdge) {
                path.removeLast();
            }

            @Override
            public void onDiscovered(Vertex<V> v, int depth, VisitorStopper stopper) {
                if (wasBfsStart(v)) {
                    for (int index : ZeroTo.get(path.size()))
                        path.get(index).status.inMatch = (index % 2 == 0);
                    FirstInArray.getFirst(path).from.free = false;
                    LastInArray.getLast(path).to.free = false;
                }
            }

            private boolean wasBfsStart(Vertex<V> v) {
                return v.side == Side.LEFT && v.free;
            }

        });
    }

    private static <V> MaximumBipartiteMatchingResult<V> createResult(Graph<Vertex<V>, Edge<V>> adj) {
        final MutableMap<V, V> match = GoodMutableMapFactory.getInstance().create();
        for (Vertex<V> v : adj.getVertices())
            for (Edge<V> e : adj.getEdges(v))
                if (e.status.inMatch)
                    match.add(e.from().original, e.to().original);

        return new MaximumBipartiteMatchingResult<V>() {
            @Override
            public V getMatchedVertex(V v) {
                return match.get(v);
            }

            @Override
            public int getMaxMatchCount() {
                return match.size() / 2;
            }

            @Override
            public boolean hasMatch(V v) {
                return match.containsKey(v);
            }
        };
    }

    private HopcroftKarpAlgorithm() {
    }
}
