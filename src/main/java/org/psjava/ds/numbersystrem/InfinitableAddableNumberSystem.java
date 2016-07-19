package org.psjava.ds.numbersystrem;

public class InfinitableAddableNumberSystem<T> implements AddableNumberSystem<InfinitableNumber<T>> {

    public static <T> InfinitableAddableNumberSystem<T> wrap(AddableNumberSystem<T> sub) {
        return new InfinitableAddableNumberSystem<T>(sub);
    }

    private final AddableNumberSystem<T> sub;
    private final InfinitableNumber<T> zero;
    private final InfinitableNumber<T> infinity;

    private InfinitableAddableNumberSystem(AddableNumberSystem<T> sub) {
        this.sub = sub;
        zero = InfinitableNumber.getFiniteInstance(sub.getZero());
        infinity = InfinitableNumber.getInfinity();
    }

    public InfinitableNumber<T> getInfinity() {
        return infinity;
    }

    @Override
    public InfinitableNumber<T> add(InfinitableNumber<T> v1, InfinitableNumber<T> v2) {
        if (v1.isInfinity() || v2.isInfinity())
            return InfinitableNumber.getInfinity();
        return InfinitableNumber.getFiniteInstance(sub.add(v1.getValue(), v2.getValue()));
    }

    @Override
    public InfinitableNumber<T> subtract(InfinitableNumber<T> minuend, InfinitableNumber<T> subtrahend) {
        if (minuend.isInfinity() || subtrahend.isInfinity())
            return InfinitableNumber.getInfinity();
        return InfinitableNumber.getFiniteInstance(sub.subtract(minuend.getValue(), subtrahend.getValue()));
    }

    @Override
    public InfinitableNumber<T> getZero() {
        return zero;
    }

    @Override
    public InfinitableNumber<T> getByInt(int v) {
        return InfinitableNumber.getFiniteInstance(sub.getByInt(v));
    }

    @Override
    public boolean isPositive(InfinitableNumber<T> v) {
        return v.isInfinity() || sub.isPositive(v.getValue());
    }

    @Override
    public boolean isZero(InfinitableNumber<T> v) {
        return !v.isInfinity() && sub.isZero(v.getValue());
    }

    @Override
    public boolean isNegative(InfinitableNumber<T> v) {
        return !v.isInfinity() && sub.isNegative(v.getValue());
    }

    @Override
    public int getSign(InfinitableNumber<T> v) {
        if (v.isInfinity())
            return 1;
        return sub.getSign(v.getValue());
    }

    @Override
    public int compare(InfinitableNumber<T> v1, InfinitableNumber<T> v2) {
        if (v1.isInfinity() && v2.isInfinity())
            return 0;
        if (v1.isInfinity())
            return 1;
        if (v2.isInfinity())
            return -1;
        return sub.compare(v1.getValue(), v2.getValue());
    }

    @Override
    public boolean areEqual(InfinitableNumber<T> o1, InfinitableNumber<T> o2) {
        return compare(o1, o2) == 0;
    }
}
