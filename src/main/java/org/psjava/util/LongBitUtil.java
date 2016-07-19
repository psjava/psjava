package org.psjava.util;

public class LongBitUtil {

    public static long set(long v, int pos) {
        return v | (1L << pos);
    }

    public static boolean get(long v, int pos) {
        return (v & (1L << pos)) > 0;
    }

    private LongBitUtil() {
    }

}
