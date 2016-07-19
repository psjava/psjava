package org.psjava.ds.numbersystrem;

import java.util.Comparator;

public interface IntegerDivisableNumberSystem<T> extends MultipliableNumberSystem<T>, Comparator<T> {
    T integerDivide(T dividend, T divisor);

    T integerRemainder(T dividend, T divisor);
}
