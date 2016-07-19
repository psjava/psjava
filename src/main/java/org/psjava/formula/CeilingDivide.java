package org.psjava.formula;

import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;

public class CeilingDivide {
    public static <T> T calc(IntegerDivisableNumberSystem<T> ns, T positiveDividend, T positiveDivisor) {
        if (ns.isNegative(positiveDividend) || ns.isNegative(positiveDivisor))
            throw new ArithmeticException();
        T one = ns.getOne();
        return ns.integerDivide(ns.add(positiveDividend, ns.subtract(positiveDivisor, one)), positiveDivisor);
    }

    private CeilingDivide() {
    }
}
