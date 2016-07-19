package org.psjava.algo.math.numbertheory;

public class PrimalityTesterByPreparedPrimeDivisionTest extends PrimalityTesterTestBase {

    @Override
    protected PrimalityTester getInstance() {
        return PrimalityTesterByPreparedPrimeDivision.getInstance(1000000, SieveOfEratosthenes.getInstance());
    }

}
