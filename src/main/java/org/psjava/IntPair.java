package org.psjava;

import org.psjava.algo.math.PairHash;

import java.util.Arrays;

public class IntPair {

    public final int v1, v2;

    public IntPair(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public int hashCode() {
        return PairHash.hash(v1, v2);
    }

    @Override
    public boolean equals(Object obj) {
        return StrictEqualityTester.areEqual(this, obj, (a, b) -> a.v1 == b.v1 && a.v2 == b.v2);
    }

    @Override
    public String toString() {
        return Arrays.asList(v1, v2).toString();
    }
}
