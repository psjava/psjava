package org.psjava.ds.numbersystrem;

public class LongNumberSystem implements IntegerDivisableNumberSystem<Long> {

    private static final LongNumberSystem INSTANCE = new LongNumberSystem();

    public static LongNumberSystem getInstance() {
        return INSTANCE;
    }

    private LongNumberSystem() {
    }

    @Override
    public Long getZero() {
        return 0L;
    }

    @Override
    public Long getByInt(int v) {
        return (long) v;
    }

    @Override
    public boolean isPositive(Long v) {
        return v > 0;
    }

    @Override
    public boolean isZero(Long v) {
        return v == 0;
    }

    @Override
    public boolean isNegative(Long v) {
        return v < 0;
    }

    @Override
    public int getSign(Long v) {
        return Long.signum(v);
    }

    @Override
    public boolean areEqual(Long o1, Long o2) {
        return o1.equals(o2);
    }

    @Override
    public Long getOne() {
        return Long.valueOf(1);
    }

    @Override
    public boolean isOne(Long v) {
        return v == 1;
    }

    @Override
    public Long add(Long v1, Long v2) {
        return GuavasLongMath.checkedAdd(v1, v2);
    }

    @Override
    public Long subtract(Long minuend, Long subtrahend) {
        return GuavasLongMath.checkedSubtract(minuend, subtrahend);
    }

    @Override
    public Long multiply(Long v1, Long v2) {
        return GuavasLongMath.checkedMultiply(v1, v2);
    }

    @Override
    public Long integerDivide(Long dividend, Long divisor) {
        return Long.valueOf(dividend / divisor);
    }

    @Override
    public Long integerRemainder(Long dividend, Long divisor) {
        return Long.valueOf(dividend % divisor);
    }

    @Override
    public int compare(Long o1, Long o2) {
        return o1.compareTo(o2);
    }

}
