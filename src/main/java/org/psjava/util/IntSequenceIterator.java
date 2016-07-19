package org.psjava.util;

import java.util.Iterator;

public class IntSequenceIterator {

    public static Iterator<Integer> create(final int start, final int step, final int size) {
        final int last = start + step * (size - 1);
        return new ReadOnlyIterator<Integer>() {
            int next = start;

            @Override
            public boolean hasNext() {
                return next <= last;
            }

            @Override
            public Integer next() {
                int r = next;
                next += step;
                return r;
            }
        };
    }

    private IntSequenceIterator() {
    }

}
