package org.psjava.algo.sequence.rmq;

import java.util.Comparator;

import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFactory;
import org.psjava.ds.math.BinaryOperator;
import org.psjava.ds.tree.segmenttree.SegmentTree;
import org.psjava.ds.tree.segmenttree.SegmentTreeFactory;
import org.psjava.util.Assertion;
import org.psjava.util.ZeroTo;

/**
 * Time complexity for preprocessing: Time complexity for constructing segment tree. known best is, O(n)
 * <p>
 * Time complexity for one query: Time complexity for one query of segment tree. known best is, O(log(n))
 * <p>
 * Space complexity: Space complexity for constructing segment tree. known best is, O(n)
 */
public class RangeMinimumQueryUsingSegmentTree {

    public static RangeMinimumQuery getInstance(final SegmentTreeFactory treeFactory) {
        return new RangeMinimumQuery() {
            @Override
            public <T> RangeMinimumQuerySession preprocess(final PSArray<T> a, final Comparator<T> comp) {
                MutableArray<Integer> indexes = MutableArrayFactory.create(a.size(), 0);
                for (int i : ZeroTo.get(a.size()))
                    indexes.set(i, i);
                final SegmentTree<Integer> tree = treeFactory.create(indexes, new BinaryOperator<Integer>() {
                    public Integer calc(Integer i1, Integer i2) {
                        return RangeMinimumQueryUtil.selectSmallestIndex(a, i1, i2, comp);
                    }
                });
                return new RangeMinimumQuerySession() {
                    public int getIndex(int start, int end) {
                        Assertion.ensure(start < end);
                        return tree.query(start, end);
                    }
                };
            }
        };
    }

    private RangeMinimumQueryUsingSegmentTree() {
    }

}
