package org.psjava.algo.sequence.rmq;

import java.util.Comparator;

import org.psjava.ds.array.Array;
import org.psjava.util.AssertStatus;
import org.psjava.util.FromTo;

/**
 * Very trivial way for range minimum query.
 * 
 * Time complexity for one query: O(n)
 * 
 * Space complexity: O(1)
 */
public class OnDemandRangeMinimumQuery {

	public static RangeMinimumQuery getInstance() {
		return new RangeMinimumQuery() {
			@Override
			public <T> RangeMinimumQuerySession preprocess(final Array<T> array, final Comparator<T> comp) {
				return new RangeMinimumQuerySession() {
					public int getIndex(int start, int end) {
						AssertStatus.assertTrue(start < end);
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
