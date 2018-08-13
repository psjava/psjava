package org.psjava.formula;

import java.util.function.BinaryOperator;

public class Power {

    public static <T> T calc(T value, int n, BinaryOperator<T> operator) {
        if (n == 1) {
            return value;
        } else {
            T sub = calc(value, n / 2, operator);
            T r = operator.apply(sub, sub);
            if (n % 2 == 1)
                r = operator.apply(r, value);
            return r;
        }
    }

}
