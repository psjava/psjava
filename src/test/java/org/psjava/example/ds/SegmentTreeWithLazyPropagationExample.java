package org.psjava.example.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.MutableArrayFromVarargs;
import org.psjava.ds.tree.segmenttree.LazyPropagatingSegmentTree;
import org.psjava.ds.tree.segmenttree.RangeUpdatableSegmentTree;

/**
 * @implementation {@link LazyPropagatingSegmentTree}
 * @implementation {@link RangeUpdatableSegmentTree}
 */
public class SegmentTreeWithLazyPropagationExample {
    @Test
    public void example() {

        // This is an advanced version of segment tree.
        // This updates the values of given range in O(logn) time.

        PSArray<Integer> init = MutableArrayFromVarargs.create(1, 1, 1, 1, 1);

        RangeUpdatableSegmentTree<Integer> sumTree = RangeUpdatableSegmentTree.create(init, (a, b) -> a + b);

        // Query by range.

        int sum1 = sumTree.query(0, 5); // must be 5=1+1+1+1+1
        Assert.assertEquals(5, sum1);

        // Update by range, this is done fast!

        sumTree.update(1, 4, 100);
        int sum2 = sumTree.query(0, 5); // must be 302=1+100+100+100+1
        Assert.assertEquals(302, sum2);

    }
}
