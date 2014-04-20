package org.psjava.algo.sequence.rmq;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.sequence.Shuffler;
import org.psjava.algo.sequence.rmq.PreprecessedRMQ;
import org.psjava.algo.sequence.rmq.RangeMinimumQuery;
import org.psjava.ds.array.AddToLastAll;
import org.psjava.ds.array.ArrayFromValues;
import org.psjava.ds.array.DynamicArray;
import org.psjava.util.DefaultComparator;
import org.psjava.util.ZeroTo;

public abstract class RangeMinimumQueryTestBase {

	protected abstract RangeMinimumQuery getInstance();

	@Test(expected = RuntimeException.class)
	public void testInvalidRange() {
		PreprecessedRMQ preprecessed = getInstance().preprocess(ArrayFromValues.create(1, 2, 3), new DefaultComparator<Integer>());
		preprecessed.query(1, 1);
	}

	@Test
	public void testRandom() {
		int n = 100;
		DynamicArray<Integer> a = DynamicArray.create();
		AddToLastAll.add(a, ZeroTo.get(100));
		Shuffler.shuffle(a);

		PreprecessedRMQ r = getInstance().preprocess(a, new DefaultComparator<Integer>());
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++) {
				int minIndex = i;
				for (int k = i; k < j; k++)
					if (a.get(minIndex) > a.get(k))
						minIndex = k;
				Assert.assertEquals(r.query(i, j), minIndex);
			}
	}

}
