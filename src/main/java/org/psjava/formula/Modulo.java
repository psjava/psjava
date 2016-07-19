package org.psjava.formula;

import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;

public class Modulo {

    /**
     * @return returned range is [0, divisor)
     */
    public static <T> T calc(IntegerDivisableNumberSystem<T> ns, T dividend, T divisor) {
        T remainder = ns.integerRemainder(dividend, divisor);
        if (ns.isNegative(remainder))
            remainder = ns.add(remainder, divisor);
        return remainder;
    }

    private Modulo() {
    }

}
