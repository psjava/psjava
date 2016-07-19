package org.psjava.util;

import org.psjava.algo.math.PairHash;
import org.psjava.util.EqualityTester;
import org.psjava.util.StrictEqualityTester;

public class Index4D implements EqualityTester<Index4D> {

    public final int i1;
    public final int i2;
    public final int i3;
    public final int i4;

    public Index4D(int i1, int i2, int i3, int i4) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
    }

    @Override
    public boolean equals(Object obj) {
        return StrictEqualityTester.areEqual(this, obj, this);
    }

    @Override
    public boolean areEqual(Index4D o1, Index4D o2) {
        return o1.i1 == o2.i1 && o1.i2 == o2.i2 && o1.i3 == o2.i3 && o1.i4 == o2.i4;
    }

    @Override
    public int hashCode() {
        return PairHash.hash(PairHash.hash(i1, i2), PairHash.hash(i3, i4));
    }

    @Override
    public String toString() {
        return "(" + i1 + "," + i2 + "," + i3 + "," + i4 + ")";
    }
}