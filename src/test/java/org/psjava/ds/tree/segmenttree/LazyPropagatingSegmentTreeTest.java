package org.psjava.ds.tree.segmenttree;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.MutableArrayFromVarargs;
import org.psjava.ds.array.UniformArray;
import org.psjava.util.FromTo;

public class LazyPropagatingSegmentTreeTest {

    private static final Random RANDOM = new Random();

    @Test
    public void testQuery() {
        LazyPropagatingSegmentTree<Integer, Integer> tree = createAddTree(MutableArrayFromVarargs.create(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(10, (int) tree.queryRange(0, 4));
    }

    @Test
    public void testUpdateSingle() {
        LazyPropagatingSegmentTree<Integer, Integer> tree = createAddTree(MutableArrayFromVarargs.create(1, 2, 3, 4, 5, 6, 7, 8));
        tree.updateRange(0, 2, 1);
        Assert.assertEquals(38, (int) tree.queryRange(0, 8));
    }

    @Test
    public void testLazyUpdate() {
        LazyPropagatingSegmentTree<Integer, Integer> tree = createAddTree(MutableArrayFromVarargs.create(1, 2, 3, 4, 5, 6, 7, 8));

        tree.updateRange(2, 4, 100);

        LazyPropagatingSegmentTree<Integer, Integer>.NodeData data = tree.root.getLeft().getRight().getData();
        Assert.assertTrue(data.lazy);
        Assert.assertEquals(207, (int) data.merged); // 103+104

        int r = tree.queryRange(1, 3); // 2+103

        Assert.assertEquals(105, r);
        Assert.assertFalse(data.lazy);
    }

    @Test
    public void testFeatureUsingNaiveMethod() {
        int n = 100;
        LazyPropagatingSegmentTree<Integer, Integer> tree = createAddTree(UniformArray.create(0, n));
        int[] a = new int[n];
        for (int i = 0; i < 100; i++) {
            int s = RANDOM.nextInt(n);
            int e = RANDOM.nextInt(n - s) + s + 1;
            int v = RANDOM.nextInt(20);
            if (i % 2 == 0) {
                tree.updateRange(s, e, v);
                for (int j : FromTo.get(s, e))
                    a[j] += v;
            } else {
                int sum = 0;
                for (int j : FromTo.get(s, e))
                    sum += a[j];
                Assert.assertEquals(sum, (int) tree.queryRange(s, e));
            }
        }
    }

    private LazyPropagatingSegmentTree<Integer, Integer> createAddTree(PSArray<Integer> init) {
        return new LazyPropagatingSegmentTree<Integer, Integer>(init, new EnhancedRangeUpdatableSegmentTreeOperator<Integer, Integer>() {

            @Override
            public Integer mergeSingleValue(Integer v1, Integer v2) {
                return v1 + v2;
            }

            @Override
            public Integer mergeRangeValue(Integer oldRangeValue, int rangeSize, Integer updateData) {
                return oldRangeValue + rangeSize * updateData;
            }

            @Override
            public Integer mergeUpdateData(Integer oldValue, Integer newValue) {
                return oldValue + newValue;
            }
        });
    }

}
