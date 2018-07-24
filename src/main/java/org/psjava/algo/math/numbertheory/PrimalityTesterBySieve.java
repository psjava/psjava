package org.psjava.algo.math.numbertheory;

import org.psjava.ds.SetFromIterableV2;
import org.psjava.util.Assertion;

import java.util.Set;

public class PrimalityTesterBySieve {

    public static PrimalityTester newInstance(PrimeNumberSieve sieve, final int max) {
        final Set<Integer> set = SetFromIterableV2.create(sieve.calcList(max));
        return new PrimalityTester() {
            @Override
            public boolean isPrime(long v) {
                Assertion.ensure(v <= max, "Too big number. adjust limit");
                return set.contains((int) v);
            }
        };
    }

}
