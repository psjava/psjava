package org.psjava.math.ns;

public interface DivisableNumberSystem<T> extends MultipliableNumberSystem<T> {
	T divide(T dividend, T divisor);
}
