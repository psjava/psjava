package org.psjava.algo.math.numbertheory;

import org.psjava.algo.math.numbertheory.PrimalityTesterByDivision;

public class PrimalityTesterByDivisionTest extends PrimalityTesterTestBase {

    @Override
    protected PrimalityTester getInstance() {
        return PrimalityTesterByDivision.getInstance();
    }

}
