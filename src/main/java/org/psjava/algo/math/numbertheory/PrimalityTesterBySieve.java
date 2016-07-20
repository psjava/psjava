package org.psjava.algo.math.numbertheory;

import org.psjava.ds.SetFromIterableV2;
import org.psjava.util.AssertStatus;

import java.util.Set;

public class PrimalityTesterBySieve {

    public static PrimalityTester newInstance(PrimeNumberSieve sieve, final int max) {
        final Set<Integer> set = SetFromIterableV2.create(sieve.calcList(max));
        return new PrimalityTester() {
            @Override
            public boolean isPrime(long v) {
                AssertStatus.assertTrue(v <= max, "Too big number. adjust limit");
                return set.contains((int) v);
            }
        };
    }

}
