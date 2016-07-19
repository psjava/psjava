package org.psjava.util;

public class ZeroTo {

    public static Iterable<Integer> get(int end) {
        return IntSequenceIterable.create(0, 1, end);
    }

    private ZeroTo() {
    }

}
