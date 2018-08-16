package org.psjava.util;

import org.psjava.StrictEqualityTester;
import org.psjava.algo.math.PairHash;

public class Pair<T1, T2> {

    public static <T1, T2> Pair<T1, T2> create(T1 v1, T2 v2) {
        return new Pair<T1, T2>(v1, v2);
    }

    public final T1 v1;
    public final T2 v2;

    public Pair(T1 v1, T2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public boolean equals(Object obj) {
        return StrictEqualityTester.areEqual(this, obj, (a, b) -> a.v1.equals(b.v1) && a.v2.equals(b.v2));
    }

    @Override
    public int hashCode() {
        return PairHash.hash(v1.hashCode(), v2.hashCode());
    }

    @Override
    public String toString() {
        return "(" + v1 + "," + v2 + ")";
    }
}