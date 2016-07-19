package org.psjava.ds.numbersystrem;

public interface MultipliableNumberSystem<T> extends AddableNumberSystem<T> {
    T multiply(T v1, T v2);

    T getOne();

    boolean isOne(T v);
}
