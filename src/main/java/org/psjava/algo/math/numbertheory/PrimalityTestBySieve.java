package org.psjava.algo.math.numbertheory;

import org.psjava.util.AssertStatus;

public class PrimalityTestBySieve {

	public static PrimalityTest create(final PrimeNumberSieve sieve, final int limit) {
		return new PrimalityTest() {
			boolean[] prime = sieve.calcPrimeMap(limit);;

			@Override
			public boolean isPrime(long v) {
				AssertStatus.assertTrue(v < prime.length, "Too big number. adjust limit");
				return prime[(int) v];
			}
		};
	}

}
