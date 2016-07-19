package org.psjava.algo.math.numbertheory;

public class PrimalityTesterByDivision {

    public static PrimalityTester getInstance() {
        return new PrimalityTester() {
            @Override
            public boolean isPrime(long v) {
                if (v < 2)
                    return false;
                for (int i = 2; i * i <= v; i++)
                    if (v % i == 0)
                        return false;
                return true;
            }
        };
    }

    private PrimalityTesterByDivision() {
    }
}
