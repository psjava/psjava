package org.psjava.algo.math.numbertheory;

import org.psjava.ds.set.Set;
import org.psjava.ds.set.SetFromIterable;
import org.psjava.util.AssertStatus;

public class PrimalityTestBySieve {

	public static PrimalityTester create(PrimeNumberSieve sieve, final int max) {
		final Set<Integer> set = SetFromIterable.create(sieve.calcList(max));
		return new PrimalityTester() {
			@Override
			public boolean isPrime(long v) {
				AssertStatus.assertTrue(v <= max, "Too big number. adjust limit");
				return set.contains((int) v);
			}
		};
	}

	private PrimalityTestBySieve() {
	}

}
