package org.psjava.algo.math.numbertheory;

import org.psjava.ds.array.Array;

/**
 * Almost same with {@link PrimalityTesterByDivision}. But if there are prepared primes, we can do division-test only for primes.
 * 
 * Then, the time is almost 10 times faster than {@link PrimalityTesterByDivision}.
 * 
 * Here, we uses prime number sieve to get prime number list.
 */

public class PrimalityTesterByPreparedPrimeDivision {

	public static PrimalityTester getInstance(long max, PrimeNumberSieve sieve) {
		final Array<Integer> primes = sieve.calcList((int) Math.sqrt(max) + 1);
		return new PrimalityTester() {

			@Override
			public boolean isPrime(long longv) {
				int v = (int) longv;
				if (v <= 1)
					return false;
				for (int p : primes) {
					if (p * p <= v) {
						if (v % p == 0)
							return false;
					} else {
						break;
					}
				}
				return true;
			}
		};
	}

	private PrimalityTesterByPreparedPrimeDivision() {
	}

}
