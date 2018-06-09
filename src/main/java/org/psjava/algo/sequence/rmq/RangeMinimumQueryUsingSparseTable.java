package org.psjava.algo.sequence.rmq;

import java.util.Comparator;

import org.psjava.ds.array.PSArray;
import org.psjava.formula.IntegerBinaryLogarithm;
import org.psjava.util.FromTo;
import org.psjava.util.ZeroTo;

/**
 * Time complexity for preprocessing: O(nlogn)
 * <p>
 * Time complexity for one query: O(1)
 * <p>
 * Space complexity: O(nlogn)
 */
public class RangeMinimumQueryUsingSparseTable {

    public static RangeMinimumQuery getInstance() {
        return new RangeMinimumQuery() {
            @Override
            public <T> RangeMinimumQuerySession preprocess(final PSArray<T> a, final Comparator<T> comp) {

                int p = Math.max(0, IntegerBinaryLogarithm.calc(a.size()) + 1);
                final int[][] table = new int[a.size()][p];

                for (int i : ZeroTo.get(a.size()))
                    table[i][0] = i;
                for (int i : FromTo.get(1, p))
                    for (int j : ZeroTo.get(a.size())) {
                        int k1 = table[j][i - 1];
                        int k2 = table[Math.min(j + (1 << (i - 1)), a.size() - 1)][i - 1];
                        table[j][i] = RangeMinimumQueryUtil.selectSmallestIndex(a, k1, k2, comp);
                    }

                return new RangeMinimumQuerySession() {
                    @Override
                    public int getIndex(int start, int end) {
                        int len = end - start;
                        int sublen = IntegerBinaryLogarithm.calc(len);
                        int i1 = table[start][sublen];
                        int i2 = table[end - (1 << sublen)][sublen];
                        return RangeMinimumQueryUtil.selectSmallestIndex(a, i1, i2, comp);
                    }
                };
            }
        };
    }

    private RangeMinimumQueryUsingSparseTable() {
    }
}
