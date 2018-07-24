package org.psjava.algo.sequence.rmq;

import java.util.Comparator;

import org.psjava.ds.array.PSArray;
import org.psjava.util.Assertion;
import org.psjava.util.FromTo;

/**
 * Very trivial way for range minimum query.
 * <p>
 * Time complexity for one query: O(n)
 * <p>
 * Space complexity: O(1)
 */
public class OnDemandRangeMinimumQuery {

    public static RangeMinimumQuery getInstance() {
        return new RangeMinimumQuery() {
            @Override
            public <T> RangeMinimumQuerySession preprocess(final PSArray<T> array, final Comparator<T> comp) {
                return new RangeMinimumQuerySession() {
                    public int getIndex(int start, int end) {
                        Assertion.ensure(start < end);
                        int r = start;
                        for (int i : FromTo.get(start + 1, end))
                            r = RangeMinimumQueryUtil.selectSmallestIndex(array, r, i, comp);
                        return r;
                    }
                };
            }
        };
    }

    private OnDemandRangeMinimumQuery() {
    }

}
