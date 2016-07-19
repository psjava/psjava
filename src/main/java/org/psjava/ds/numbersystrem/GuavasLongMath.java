package org.psjava.ds.numbersystrem;

public class GuavasLongMath {

    public static long checkedAdd(long a, long b) {
        long result = a + b;
        assertOverflowCondition((a ^ b) < 0 | (a ^ result) >= 0);
        return result;
    }

    public static long checkedSubtract(long a, long b) {
        long result = a - b;
        assertOverflowCondition((a ^ b) >= 0 | (a ^ result) >= 0);
        return result;
    }

    public static long checkedMultiply(long a, long b) {
        int leadingZeros = Long.numberOfLeadingZeros(a) + Long.numberOfLeadingZeros(~a) + Long.numberOfLeadingZeros(b) + Long.numberOfLeadingZeros(~b);
        if (leadingZeros > Long.SIZE + 1) {
            return a * b;
        }
        assertOverflowCondition(leadingZeros >= Long.SIZE);
        assertOverflowCondition(a >= 0 | b != Long.MIN_VALUE);
        long result = a * b;
        assertOverflowCondition(a == 0 || result / a == b);
        return result;
    }

    private static void assertOverflowCondition(boolean c) {
        if (!c)
            throw OverflowException.create();
    }

}
