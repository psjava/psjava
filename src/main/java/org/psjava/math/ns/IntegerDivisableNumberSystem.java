package org.psjava.math.ns;

import java.util.Comparator;

public interface IntegerDivisableNumberSystem<T> extends MultipliableNumberSystem<T>, Comparator<T> {
	T integerDivide(T dividend, T divisor);
	T integerRemainder(T dividend, T divisor);
}
