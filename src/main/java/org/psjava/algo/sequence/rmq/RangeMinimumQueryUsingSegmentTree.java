package org.psjava.algo.sequence.rmq;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.psjava.ds.array.PSArray;
import org.psjava.SegmentTree;
import org.psjava.util.Assertion;

/**
 * Time complexity for preprocessing: Time complexity for constructing segment tree. known best is, O(n)
 * <p>
 * Time complexity for one query: Time complexity for one query of segment tree. known best is, O(log(n))
 * <p>
 * Space complexity: Space complexity for constructing segment tree. known best is, O(n)
 */
public class RangeMinimumQueryUsingSegmentTree {

    public static final RangeMinimumQuery INSTANCE = new RangeMinimumQuery() {
        @Override
        public <T> RangeMinimumQuerySession preprocess(final PSArray<T> a, final Comparator<T> comp) {
            List<Integer> init = IntStream.range(0, a.size())
                    .boxed().collect(Collectors.toList());
            final SegmentTree<Integer> tree = new SegmentTree<>(init, (i1, i2) -> RangeMinimumQueryUtil.selectSmallestIndex(a, i1, i2, comp));
            return (start, end) -> {
                Assertion.ensure(start < end);
                return tree.query(start, end);
            };
        }
    };

}
