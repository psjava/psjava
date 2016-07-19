package org.psjava.ds.numbersystrem;

public interface DivisableNumberSystem<T> extends MultipliableNumberSystem<T> {
    T divide(T dividend, T divisor);
}
