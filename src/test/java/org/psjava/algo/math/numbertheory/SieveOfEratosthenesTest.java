package org.psjava.algo.math.numbertheory;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.math.numbertheory.SieveOfEratosthenes;
import org.psjava.ds.set.Set;
import org.psjava.ds.set.SetFromVarargs;
import org.psjava.util.ZeroTo;

public class SieveOfEratosthenesTest {

	@Test
	public void test() {
		boolean[] r = SieveOfEratosthenes.getInstance().calcPrimeMap(10000);
		Set<Integer> expected = SetFromVarargs.create(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		for (int i : ZeroTo.get(30))
			Assert.assertEquals(expected.contains(i), r[i]);
	}
}
