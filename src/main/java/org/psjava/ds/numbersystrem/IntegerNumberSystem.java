package org.psjava.ds.numbersystrem;

public class IntegerNumberSystem implements IntegerDivisableNumberSystem<Integer> {

    private static final IntegerNumberSystem INSTANCE = new IntegerNumberSystem();

    public static IntegerNumberSystem getInstance() {
        return INSTANCE;
    }

    private IntegerNumberSystem() {
    }

    @Override
    public Integer getZero() {
        return Integer.valueOf(0);
    }

    @Override
    public Integer getByInt(int v) {
        return v;
    }

    @Override
    public boolean isPositive(Integer v) {
        return v.intValue() > 0;
    }

    @Override
    public boolean isZero(Integer v) {
        return v.intValue() == 0;
    }

    @Override
    public boolean isNegative(Integer v) {
        return v.intValue() < 0;
    }

    @Override
    public int getSign(Integer v) {
        return Integer.signum(v);
    }

    @Override
    public boolean areEqual(Integer o1, Integer o2) {
        return o1.equals(o2);
    }

    @Override
    public Integer getOne() {
        return Integer.valueOf(1);
    }

    @Override
    public boolean isOne(Integer v) {
        return v.intValue() == 1;
    }

    @Override
    public Integer add(Integer v1, Integer v2) {
        return safeCastFromLong((long) v1 + (long) v2);
    }

    @Override
    public Integer subtract(Integer minuend, Integer subtrahend) {
        return safeCastFromLong((long) minuend - (long) subtrahend);
    }

    @Override
    public Integer multiply(Integer v1, Integer v2) {
        return safeCastFromLong((long) v1 * (long) v2);
    }

    @Override
    public Integer integerDivide(Integer dividend, Integer divisor) {
        return Integer.valueOf(dividend / divisor);
    }

    @Override
    public Integer integerRemainder(Integer dividend, Integer divisor) {
        return Integer.valueOf(dividend % divisor);
    }

    private Integer safeCastFromLong(long v) {
        if (v != (int) v)
            throw OverflowException.create();
        return Integer.valueOf((int) v);
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }

}
