package org.psjava.example.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.MutableArrayFromVarargs;
import org.psjava.ds.tree.segmenttree.SegmentTree;
import org.psjava.ds.tree.segmenttree.SegmentTreeByArrayImplementation;

/**
 * @implementation {@link SegmentTreeByArrayImplementation}
 */
public class SegmentTreeExample {
    @Test
    public void example() {

        // Create an initial tree with an array, and a binary operator.
        // The binary operator can be adder, multiplier or anything you define.

        PSArray<Integer> init = MutableArrayFromVarargs.create(4, 3, 1, 5, 2);

        SegmentTree<Integer> maxTree = new SegmentTreeByArrayImplementation<>(init, Math::max);

        // query by range.

        int max1 = maxTree.query(1, 4); // maximum is 5 among (3, 1, 5)
        Assert.assertEquals(5, max1);

        // update one element. and query again to get updated result.

        maxTree.update(2, 99);

        int max2 = maxTree.query(1, 4); // now, maximum is 99 among (3, 99, 5)
        Assert.assertEquals(99, max2);

    }
}
