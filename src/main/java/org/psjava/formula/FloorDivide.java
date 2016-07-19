package org.psjava.formula;

import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;

public class FloorDivide {

    public static <T> T calc(IntegerDivisableNumberSystem<T> ns, T dividend, T divisor) {
        T div = ns.integerDivide(dividend, divisor);
        if (ns.isNegative(dividend) == ns.isNegative(divisor))
            return div;
        else
            return ns.subtract(div, ns.getOne());
    }

    private FloorDivide() {
    }

}
