package org.psjava.example;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.math.numbertheory.PrimeNumberSieve;
import org.psjava.algo.math.numbertheory.SieveOfEratosthenes;

public class PrimeNumberSieveExample {

	@Test
	public void example() {

		// Select sieve algorithm, and just call it.

		PrimeNumberSieve algo = SieveOfEratosthenes.getInstance();
		boolean[] prime = algo.calcPrimeMap(30);

		// 29 is a prime number, 25 is not.

		Assert.assertEquals(true, prime[29]);
		Assert.assertEquals(false, prime[25]);
	}
}
