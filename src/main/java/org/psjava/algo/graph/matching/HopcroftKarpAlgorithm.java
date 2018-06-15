package org.psjava.algo.graph.matching;

import org.psjava.AdjacencyList;
import org.psjava.EdgeFilteredSubAdjacencyList;
import org.psjava.First;
import org.psjava.Last;
import org.psjava.RemoveLast;
import org.psjava.algo.graph.bfs.BFS;
import org.psjava.algo.graph.bfs.BFSVisitor;
import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.MultiSourceDFS;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
                    dfs(graph::getEdges, bfsFinishes, bfsMark);
                }
                int count = 0;
                for (Vertex<V> v : graph.getVertices())
                    for (Edge<V> e : graph.getEdges(v))
                        if (e.status.inMatch && e.from.side == Side.LEFT)
                            count++;
                return count;
            }
        };
    }

    private enum Side {
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

    private static <V> void dfs(AdjacencyList<Vertex<V>, Edge<V>> adj, Collection<Vertex<V>> bfsFinishes, Object bfsMark) {
        // uses only edges discovered in bfs step.
        AdjacencyList<Vertex<V>, Edge<V>> subAdj = EdgeFilteredSubAdjacencyList.wrap(adj, edge -> edge.status.bfsMark == bfsMark);

        MultiSourceDFS.traverse(subAdj, DirectedEdge::to, bfsFinishes, new DFSVisitorBase<Vertex<V>, Edge<V>>() {
            List<Edge<V>> path = new ArrayList<>();

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
                if (v.side == Side.LEFT && v.free) {
                    for (int index : ZeroTo.get(path.size()))
                        path.get(index).status.inMatch = (index % 2 == 0);
                    First.first(path).from.free = false;
                    Last.last(path).to.free = false;
                }
            }

        });
    }

}
