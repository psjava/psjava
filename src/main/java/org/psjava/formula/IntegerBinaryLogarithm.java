package org.psjava.formula;

import org.psjava.util.Assertion;

public class IntegerBinaryLogarithm {

    public static int calc(int v) {
        Assertion.ensure(v >= 1, "Logarithm argument must be positive");
        return 31 - Integer.numberOfLeadingZeros(v);
    }

    private IntegerBinaryLogarithm() {
    }
}
