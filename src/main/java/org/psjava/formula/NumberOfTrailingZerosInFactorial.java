package org.psjava.formula;

import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;

/**
 * Calculates the number of trailing zeros in the decimal representation of n!
 * <p>
 * http://en.wikipedia.org/wiki/Trailing_zeros
 */
public class NumberOfTrailingZerosInFactorial {

    public static <T> T calc(T n, IntegerDivisableNumberSystem<T> ns) {
        T five = ns.getByInt(5);
        T numberOfFiveFactor = ns.getZero();
        while (ns.isPositive(n)) {
            n = ns.integerDivide(n, five);
            numberOfFiveFactor = ns.add(numberOfFiveFactor, n);
        }
        return numberOfFiveFactor;
    }

    private NumberOfTrailingZerosInFactorial() {
    }

}
