package org.psjava.ds.numbersystrem;

public interface AddableNumberSystem<T> extends NumberSystem<T> {
    T add(T v1, T v2);

    T subtract(T minuend, T subtrahend);

    T getZero();

    T getByInt(int v);

    boolean isPositive(T v);

    boolean isZero(T v);

    boolean isNegative(T v);

    int getSign(T v);
}
