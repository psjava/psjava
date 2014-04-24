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
public class OnDemandRMQ {

	public static RangeMinimumQuery getInstance() {
		return new RangeMinimumQuery() {
			@Override
			public <T> PreprecessedRMQ preprocess(final Array<T> array, final Comparator<T> comp) {
				return new PreprecessedRMQ() {
					public int queryIndex(int start, int end) {
						AssertStatus.assertTrue(start < end);
						int r = start;
						for (int i : FromTo.get(start + 1, end))
							r = RMQUtil.selectSmallestIndex(array, r, i, comp);
						return r;
					}
				};
			}
		};
	}

	private OnDemandRMQ() {
	}

}
