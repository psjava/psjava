package org.psjava.algo.math;

/**
 * from http://www.concentric.net/~ttwang/tech/inthash.htm
 */
public class ThomasWangHash32Bit {

    public static int hash(int v) {
        v = ~v + (v << 15); // key = (key << 15) - key - 1;
        v = v ^ (v >>> 12);
        v = v + (v << 2);
        v = v ^ (v >>> 4);
        v = v * 2057; // key = (key + (key << 3)) + (key << 11);
        v = v ^ (v >>> 16);
        return v;
    }

    private ThomasWangHash32Bit() {
    }

}
