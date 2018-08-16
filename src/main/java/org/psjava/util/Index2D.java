package org.psjava.util;

import org.psjava.algo.math.PairHash;

public class Index2D {

    public final int i1;
    public final int i2;

    public Index2D(int i, int j) {
        this.i1 = i;
        this.i2 = j;
    }

    @Override
    public boolean equals(Object obj) {
        return StrictEqualityTester.areEqual(this, obj, (o1, o2) -> o1.i1 == o2.i1 && o1.i2 == o2.i2);
    }

    @Override
    public int hashCode() {
        return PairHash.hash(i1, i2);
    }

    @Override
    public String toString() {
        return "(" + i1 + "," + i2 + ")";
    }
}