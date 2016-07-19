package org.psjava.util;

public class FromTo {

    public static Iterable<Integer> get(int begin, int end) {
        return IntSequenceIterable.create(begin, 1, end - begin);
    }

    private FromTo() {
    }

}
