package org.psjava.algo.graph;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.sequence.rmq.OnDemandRangeMinimumQuery;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.RootedTree;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.ds.map.JavaHashMapFactory;

public class LowestCommonAncestorAlgorithmTest {

    private static final LowestCommonAncestorAlgorithm INSTANCE = new LowestCommonAncestorAlgorithm(OnDemandRangeMinimumQuery.getInstance(), JavaHashMapFactory.getInstance());

    @Test
    public void testOne() {
        Graph<String, DirectedEdge<String>> g = TestGraphFactory.createDirectedNew(new String[][]{{"0", "1"}, {"0", "2"}, {"2", "3"}, {"2", "4"}});
        LowestCommonAncestorQuerySession<String> r = INSTANCE.calc(RootedTree.wrap(g, "0"));

        Assert.assertEquals("2", r.query("3", "4"));
        Assert.assertEquals("0", r.query("1", "4"));
        Assert.assertEquals("4", r.query("4", "4"));
        Assert.assertEquals("0", r.query("4", "0"));
        Assert.assertEquals("0", r.query("3", "0"));
    }
}
