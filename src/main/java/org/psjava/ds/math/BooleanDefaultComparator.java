package org.psjava.ds.math;

import java.util.Comparator;

import org.psjava.util.DefaultComparator;

public class BooleanDefaultComparator {

    private static final Comparator<Boolean> INSTANCE = new DefaultComparator<Boolean>();

    public static Comparator<Boolean> getInstance() {
        return INSTANCE;
    }

    private BooleanDefaultComparator() {
    }

}
