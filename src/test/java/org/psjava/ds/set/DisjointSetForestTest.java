package org.psjava.ds.set;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.util.ZeroTo;

public class DisjointSetForestTest {

    @Test
    public void testSet1() {
        DisjointSet<Integer> ds = new DisjointSetForest<Integer>();
        MakeSetAll.make(ds, ZeroTo.get(5));
        Assert.assertTrue(ds.find(1) != ds.find(2));
        ds.union(1, 2);
        Assert.assertTrue(ds.find(1) == ds.find(2));

        Assert.assertTrue(ds.find(1) != ds.find(4));
        Assert.assertTrue(ds.find(2) != ds.find(4));
        ds.union(1, 4);
        Assert.assertTrue(ds.find(1) == ds.find(4));
        Assert.assertTrue(ds.find(2) == ds.find(4));
    }

}
