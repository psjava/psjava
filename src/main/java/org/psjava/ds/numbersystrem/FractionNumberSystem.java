package org.psjava.ds.numbersystrem;

import java.util.Comparator;

import org.psjava.algo.math.numbertheory.GCD;

public class FractionNumberSystem<T> implements DivisableNumberSystem<Fraction<T>>, Comparator<Fraction<T>> {

    public static <T> FractionNumberSystem<T> newInstance(IntegerDivisableNumberSystem<T> subSystem) {
        return new FractionNumberSystem<T>(subSystem);
    }

    private final IntegerDivisableNumberSystem<T> ns;

    private FractionNumberSystem(IntegerDivisableNumberSystem<T> subSystem) {
        this.ns = subSystem;
    }

    @Override
    public Fraction<T> getOne() {
        return Fraction.valueOf(ns.getOne(), ns.getOne());
    }

    @Override
    public Fraction<T> getZero() {
        return Fraction.valueOf(ns.getZero(), ns.getOne());
    }

    @Override
    public Fraction<T> getByInt(int v) {
        return Fraction.valueOf(ns.getByInt(v), ns.getOne());
    }

    @Override
    public Fraction<T> add(Fraction<T> v1, Fraction<T> v2) {
        T num = ns.add(ns.multiply(v1.numerator, v2.denominator), ns.multiply(v2.numerator, v1.denominator));
        T denom = ns.multiply(v1.denominator, v2.denominator);
        return reduce(num, denom);
    }

    @Override
    public Fraction<T> subtract(Fraction<T> minuend, Fraction<T> subtrahend) {
        T num = ns.subtract(ns.multiply(minuend.numerator, subtrahend.denominator), ns.multiply(subtrahend.numerator, minuend.denominator));
        T denom = ns.multiply(minuend.denominator, subtrahend.denominator);
        return reduce(num, denom);
    }

    @Override
    public Fraction<T> multiply(Fraction<T> v1, Fraction<T> v2) {
        T num = ns.multiply(v1.numerator, v2.numerator);
        T denom = ns.multiply(v1.denominator, v2.denominator);
        return reduce(num, denom);
    }

    @Override
    public boolean areEqual(Fraction<T> o1, Fraction<T> o2) {
        T t1 = ns.multiply(o1.numerator, o2.denominator);
        T t2 = ns.multiply(o2.numerator, o1.denominator);
        return ns.areEqual(t1, t2);
    }

    @Override
    public Fraction<T> divide(Fraction<T> dividend, Fraction<T> divisor) {
        T num = ns.multiply(dividend.numerator, divisor.denominator);
        T denom = ns.multiply(dividend.denominator, divisor.numerator);
        return reduce(num, denom);
    }

    @Override
    public int getSign(Fraction<T> v) {
        return ns.getSign(v.numerator) * ns.getSign(v.denominator);
    }

    @Override
    public boolean isNegative(Fraction<T> v) {
        return getSign(v) < 0;
    }

    @Override
    public boolean isOne(Fraction<T> v) {
        return ns.areEqual(v.numerator, v.denominator);
    }

    @Override
    public boolean isPositive(Fraction<T> v) {
        return getSign(v) > 0;
    }

    @Override
    public boolean isZero(Fraction<T> v) {
        return ns.isZero(v.numerator);
    }

    @Override
    public int compare(Fraction<T> o1, Fraction<T> o2) {
        o1 = reduce(o1);
        o2 = reduce(o2);
        T v1 = ns.multiply(o1.numerator, o2.denominator);
        T v2 = ns.multiply(o2.numerator, o1.denominator);
        return ns.compare(v1, v2);
    }

    public Fraction<T> reduce(Fraction<T> v) {
        return reduce(v.numerator, v.denominator);
    }

    private Fraction<T> reduce(T num, T denom) {
        if (ns.isNegative(denom)) {
            num = AddInvert.calc(ns, num);
            denom = AddInvert.calc(ns, denom);
        }
        T gcd = GCD.gcd(ns, num, denom);
        num = ns.integerDivide(num, gcd);
        denom = ns.integerDivide(denom, gcd);
        return Fraction.valueOf(num, denom);
    }

}
