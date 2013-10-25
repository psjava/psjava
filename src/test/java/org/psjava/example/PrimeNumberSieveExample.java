package org.psjava.example;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.math.numbertheory.PrimeNumberSieve;
import org.psjava.algo.math.numbertheory.SieveOfEratosthenes;
import org.psjava.ds.array.Array;

public class PrimeNumberSieveExample {

	@Test
	public void example() {

		// Select sieve algorithm, and just call it.

		PrimeNumberSieve algo = SieveOfEratosthenes.getInstance();
		Array<Integer> primes = algo.calcList(30);

		int number = primes.size(); // there are 10 primes. between [1~30]
		int prime1 = primes.get(0); // first prime is 2
		int prime8 = primes.get(7); // 8th prime is 19

		// assertions
		Assert.assertEquals(10, number);
		Assert.assertEquals(2, prime1);
		Assert.assertEquals(19, prime8);
	}
}
