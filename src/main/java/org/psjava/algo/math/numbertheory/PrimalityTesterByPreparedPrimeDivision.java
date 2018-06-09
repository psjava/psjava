package org.psjava.algo.math.numbertheory;

import org.psjava.ds.array.PSArray;

/**
 * Almost same with {@link PrimalityTesterByDivision}. But if there are prepared primes, we can do division-test only for primes.
 * <p>
 * Then, the time is almost 10 times faster than {@link PrimalityTesterByDivision}.
 * <p>
 * Here, we uses prime number sieve to get prime number list.
 */

public class PrimalityTesterByPreparedPrimeDivision {

    public static PrimalityTester getInstance(long max, PrimeNumberSieve sieve) {
        final PSArray<Integer> primes = sieve.calcList((int) Math.sqrt(max) + 1);
        return new PrimalityTester() {
            @Override
            public boolean isPrime(long v) {
                if (v <= 1)
                    return false;
                for (long p : primes) {
                    if (p * p > v)
                        break;
                    if (v % p == 0)
                        return false;
                }
                return true;
            }
        };
    }

    private PrimalityTesterByPreparedPrimeDivision() {
    }

}
