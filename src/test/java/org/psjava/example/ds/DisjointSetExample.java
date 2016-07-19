package org.psjava.example.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.set.DisjointSet;
import org.psjava.ds.set.DisjointSetForest;
import org.psjava.goods.GoodDisjointSet;

/**
 * @implementation {@link DisjointSetForest}
 */
public class DisjointSetExample {

    @Test
    public void example() {

        DisjointSet<String> set = GoodDisjointSet.create();

        set.makeSet("A");
        set.makeSet("B");
        set.makeSet("C");
        set.makeSet("D");

        set.union("C", "D");

        // representiatives for "C", "D" are now same.

        String rep1 = set.find("C");
        String rep2 = set.find("D");
        Assert.assertEquals(rep1, rep2);
    }

}
