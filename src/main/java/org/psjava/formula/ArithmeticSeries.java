package org.psjava.formula;

import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;

/**
 * sum of arithmetic progression
 */

public class ArithmeticSeries {

    public static <T> T calc(IntegerDivisableNumberSystem<T> ns, T a1, T difference, T number) {
        T an = ns.add(a1, ns.multiply(ns.subtract(number, ns.getOne()), difference));
        T two = ns.add(ns.getOne(), ns.getOne());
        return ns.integerDivide(ns.multiply(ns.add(a1, an), number), two);
    }

    private ArithmeticSeries() {
    }

}
