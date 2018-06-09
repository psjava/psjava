package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.math.numbertheory.PrimeNumberSieve;
import org.psjava.algo.math.numbertheory.SieveOfEratosthenes;
import org.psjava.ds.array.PSArray;

/**
 * @implementation {@link SieveOfEratosthenes}
 */
public class SieveOfEratosthenesExample {

    @Test
    public void example() {

        // Select sieve algorithm, and just call it.

        PrimeNumberSieve sieve = SieveOfEratosthenes.getInstance();
        PSArray<Integer> primes = sieve.calcList(30);

        int number = primes.size(); // there are 10 primes. between [1~30]
        int prime1st = primes.get(0); // first prime is 2
        int prime8th = primes.get(7); // 8th prime is 19

        Assert.assertEquals(10, number);
        Assert.assertEquals(2, prime1st);
        Assert.assertEquals(19, prime8th);
    }
}
