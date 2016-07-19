package org.psjava.ds.numbersystrem;

import org.psjava.formula.Modulo;

public class ModularNumberSystem<T> implements MultipliableNumberSystem<T> {

    public static <T> ModularNumberSystem<T> newInstance(IntegerDivisableNumberSystem<T> originalSystem, T modular) {
        return new ModularNumberSystem<T>(originalSystem, modular);
    }

    private final IntegerDivisableNumberSystem<T> ns;
    private final T m;

    private ModularNumberSystem(IntegerDivisableNumberSystem<T> originalSystem, T modular) {
        this.ns = originalSystem;
        this.m = modular;
    }

    @Override
    public T getZero() {
        return ns.getZero();
    }

    @Override
    public T getOne() {
        return ns.getOne();
    }

    @Override
    public T getByInt(int v) {
        return modulo(ns.getByInt(v));
    }

    @Override
    public boolean isOne(T v) {
        return ns.isOne(modulo(v));
    }

    @Override
    public boolean isPositive(T v) {
        return ns.isPositive(modulo(v));
    }

    @Override
    public boolean isNegative(T v) {
        return false;
    }

    @Override
    public boolean isZero(T v) {
        return ns.isZero(modulo(v));
    }

    @Override
    public int getSign(T v) {
        return ns.getSign(modulo(v));
    }

    @Override
    public boolean areEqual(T v1, T v2) {
        return ns.areEqual(modulo(v1), modulo(v2));
    }

    @Override
    public T add(T v1, T v2) {
        return modulo(ns.add(v1, v2));
    }

    @Override
    public T subtract(T minuend, T subtrahend) {
        return modulo(ns.subtract(minuend, subtrahend));
    }

    @Override
    public T multiply(T v1, T v2) {
        return modulo(ns.multiply(v1, v2));
    }

    private T modulo(T v) {
        return Modulo.calc(ns, v, m);
    }

    @Override
    public int compare(T o1, T o2) {
        return ns.compare(modulo(o1), modulo(o2));
    }

}
