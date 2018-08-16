package org.psjava.util;

import org.psjava.algo.math.PairHash;

public class Index3D {

    public final int i1;
    public final int i2;
    public final int i3;

    public Index3D(int i1, int i2, int i3) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
    }

    @Override
    public boolean equals(Object obj) {
        return StrictEqualityTester.areEqual(this, obj, (o1, o2) -> o1.i1 == o2.i1 && o1.i2 == o2.i2 && o1.i3 == o2.i3);
    }

    @Override
    public int hashCode() {
        return PairHash.hash(PairHash.hash(i1, i2), i3);
    }

    @Override
    public String toString() {
        return "(" + i1 + "," + i2 + "," + i3 + ")";
    }
}