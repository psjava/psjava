package org.psjava.algo.math.numbertheory;

import java.util.Arrays;

import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.DynamicArray;
import org.psjava.util.ZeroTo;

public class SieveOfEratosthenes {

    /**
     * Implementation of Sieve of Eratosthenes
     * <p>
     * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     */

    public static PrimeNumberSieve getInstance() {
        return new PrimeNumberSieve() {
            @Override
            public PSArray<Integer> calcList(int max) {
                boolean[] prime = new boolean[max + 1];
                Arrays.fill(prime, true);
                prime[0] = false;
                prime[1] = false;
                for (int i = 2; i <= max; i++)
                    if (prime[i])
                        for (int j = i + i; j <= max; j += i)
                            prime[j] = false;
                return toArray(max, prime);
            }
        };
    }

    private static DynamicArray<Integer> toArray(int max, boolean[] prime) {
        DynamicArray<Integer> r = DynamicArray.create();
        for (int i : ZeroTo.get(max))
            if (prime[i])
                r.addToLast(i);
        return r;
    }

    private SieveOfEratosthenes() {
    }

}
