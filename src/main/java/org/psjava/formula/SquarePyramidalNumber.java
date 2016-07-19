package org.psjava.formula;

import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;

/**
 * http://en.wikipedia.org/wiki/Square_pyramidal_number
 */

public class SquarePyramidalNumber {
    @SuppressWarnings("unchecked")
    public static <T> T calc(T n, IntegerDivisableNumberSystem<T> ns) {
        T t1 = n;
        T t2 = ns.add(n, ns.getOne());
        T t3 = SumOfVarargs.calc(ns, n, n, ns.getOne());
        return ns.integerDivide(ProductOfVarargs.product(ns, t1, t2, t3), ns.getByInt(6));
    }

    private SquarePyramidalNumber() {
    }
}
