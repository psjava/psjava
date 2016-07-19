package org.psjava.algo.math;

/**
 * from http://www.concentric.net/~ttwang/tech/inthash.htm
 */
public class ThomasWangHash64Bit {

    private ThomasWangHash64Bit() {
    }

    public static int hash(long v) {
        v = (~v) + (v << 18); // key = (key << 18) - key - 1;
        v = v ^ (v >>> 31);
        v = v * 21; // key = (key + (key << 2)) + (key << 4);
        v = v ^ (v >>> 11);
        v = v + (v << 6);
        v = v ^ (v >>> 22);
        return (int) v;
    }

}
