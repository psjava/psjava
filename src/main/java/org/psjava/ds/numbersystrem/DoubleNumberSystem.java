package org.psjava.ds.numbersystrem;

import java.util.Comparator;

public class DoubleNumberSystem implements DivisableNumberSystem<Double>, Comparator<Double> {

    private static DoubleNumberSystem INSTANCE = new DoubleNumberSystem();

    public static DoubleNumberSystem getInstance() {
        return INSTANCE;
    }

    private DoubleNumberSystem() {
    }

    @Override
    public Double getOne() {
        return Double.valueOf(1);
    }

    @Override
    public Double getZero() {
        return Double.valueOf(0);
    }

    @Override
    public Double getByInt(int v) {
        return (double) v;
    }

    @Override
    public boolean isNegative(Double v) {
        return v < 0;
    }

    @Override
    public boolean isOne(Double v) {
        return v == 1;
    }

    @Override
    public boolean isPositive(Double v) {
        return v > 0;
    }

    @Override
    public boolean isZero(Double v) {
        return v == 0;
    }

    @Override
    public boolean areEqual(Double o1, Double o2) {
        return o1.equals(o2);
    }

    @Override
    public int compare(Double o1, Double o2) {
        return o1.compareTo(o2);
    }

    @Override
    public int getSign(Double v) {
        return Double.compare(v, 0);
    }

    @Override
    public Double add(Double v1, Double v2) {
        return Double.valueOf(v1 + v2);
    }

    @Override
    public Double subtract(Double minuend, Double subtrahend) {
        return Double.valueOf(minuend - subtrahend);
    }

    @Override
    public Double divide(Double dividend, Double divisor) {
        return Double.valueOf(dividend / divisor);
    }

    @Override
    public Double multiply(Double v1, Double v2) {
        return Double.valueOf(v1 * v2);
    }
}
