package org.psjava.algo.math.numbertheory;

import java.util.Arrays;

public class SieveOfEratosthenes {

	/**
	 * Implementation of Sieve of Eratosthenes
	 * 
	 * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 */

	public static PrimeNumberSieve getInstance() {
		return new PrimeNumberSieve() {
			@Override
			public boolean[] calcPrimeMap(int limit) {
				boolean[] prime = new boolean[limit + 1];
				Arrays.fill(prime, true);
				prime[0] = false;
				prime[1] = false;
				for (int i = 2; i <= limit; i++)
					if (prime[i])
						for (int j = i + i; j <= limit; j += i)
							prime[j] = false;
				return prime;
			}
		};
	}

}
