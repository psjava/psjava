package org.psjava.ds.numbersystrem;

import java.math.BigInteger;

public class BigIntegerNumberSystem implements IntegerDivisableNumberSystem<BigInteger> {

    private static final BigIntegerNumberSystem INSTANCE = new BigIntegerNumberSystem();

    public static BigIntegerNumberSystem getInstance() {
        return INSTANCE;
    }

    private BigIntegerNumberSystem() {
    }

    @Override
    public BigInteger getZero() {
        return BigInteger.ZERO;
    }

    @Override
    public BigInteger getByInt(int v) {
        return BigInteger.valueOf(v);
    }

    @Override
    public boolean isPositive(BigInteger v) {
        return v.signum() > 0;
    }

    @Override
    public boolean isZero(BigInteger v) {
        return v.signum() == 0;
    }

    @Override
    public boolean isNegative(BigInteger v) {
        return v.signum() < 0;
    }

    @Override
    public int getSign(BigInteger v) {
        return v.signum();
    }

    @Override
    public boolean areEqual(BigInteger o1, BigInteger o2) {
        return o1.equals(o2);
    }

    @Override
    public BigInteger getOne() {
        return BigInteger.ONE;
    }

    @Override
    public boolean isOne(BigInteger v) {
        return v.equals(BigInteger.ONE);
    }

    @Override
    public BigInteger add(BigInteger v1, BigInteger v2) {
        return v1.add(v2);
    }

    @Override
    public BigInteger subtract(BigInteger minuend, BigInteger subtrahend) {
        return minuend.subtract(subtrahend);
    }

    @Override
    public BigInteger multiply(BigInteger v1, BigInteger v2) {
        return v1.multiply(v2);
    }

    @Override
    public BigInteger integerDivide(BigInteger dividend, BigInteger divisor) {
        return dividend.divide(divisor);
    }

    @Override
    public BigInteger integerRemainder(BigInteger dividend, BigInteger divisor) {
        return dividend.remainder(divisor);
    }

    @Override
    public int compare(BigInteger o1, BigInteger o2) {
        return o1.compareTo(o2);
    }

}
