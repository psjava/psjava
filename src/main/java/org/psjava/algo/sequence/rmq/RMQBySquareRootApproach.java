package org.psjava.algo.sequence.rmq;

import java.util.Comparator;

import org.psjava.ds.array.Array;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.formula.CeilingDivide;
import org.psjava.util.AssertStatus;
import org.psjava.util.FromTo;
import org.psjava.util.ZeroTo;

/**
 * Time complexity for preprocessing: O(n)
 * 
 * Time complexity for one query: O(sqrt(n))
 * 
 * Space complexity: O(sqrt(t))
 */
public class RMQBySquareRootApproach implements RangeMinimumQuery {

	public <T> PreprecessedRMQ preprocess(final Array<T> a, final Comparator<T> comp) {
		final int partLength = Math.max(1, (int) Math.sqrt(a.size()));
		final int[] minInPart = new int[CeilingDivide.calc(IntegerNumberSystem.getInstance(), a.size(), partLength)];
		for (int i : ZeroTo.get(minInPart.length)) {
			minInPart[i] = i * partLength;
			for (int j : FromTo.get(i * partLength + 1, Math.min((i + 1) * partLength, a.size())))
				minInPart[i] = RMQUtil.selectSmallestIndex(a, j, minInPart[i], comp);
		}

		return new PreprecessedRMQ() {
			public int query(int start, int end) {
				AssertStatus.assertTrue(start < end);
				int firstPart = start / partLength;
				int lastPart = (end - 1) / partLength;
				int r = start;
				if (firstPart == lastPart) {
					for (int i : FromTo.get(start, end))
						r = RMQUtil.selectSmallestIndex(a, i, r, comp);
				} else {
					for (int i : FromTo.get(start, partLength * (firstPart + 1)))
						r = RMQUtil.selectSmallestIndex(a, i, r, comp);
					for (int i : FromTo.get(firstPart + 1, lastPart))
						r = RMQUtil.selectSmallestIndex(a, minInPart[i], r, comp);
					for (int i : FromTo.get(partLength * lastPart, end))
						r = RMQUtil.selectSmallestIndex(a, i, r, comp);
				}
				return r;
			}
		};
	}
}
