package org.psjava.util;

import org.psjava.StrictEqualityTester;
import org.psjava.algo.math.PairHash;

public class Quadruple<T1, T2, T3, T4> {

    public static <T1, T2, T3, T4> Quadruple<T1, T2, T3, T4> create(T1 v1, T2 v2, T3 v3, T4 v4) {
        return new Quadruple<T1, T2, T3, T4>(v1, v2, v3, v4);
    }

    public final T1 v1;
    public final T2 v2;
    public final T3 v3;
    public final T4 v4;

    public Quadruple(T1 v1, T2 v2, T3 v3, T4 v4) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }

    @Override
    public boolean equals(Object obj) {
        return StrictEqualityTester.areEqual(this, obj, (a, b) -> a.v1.equals(b.v1) && a.v2.equals(b.v2) && a.v3.equals(b.v3) && a.v4.equals(b.v4));
    }

    @Override
    public int hashCode() {
        return PairHash.hash(PairHash.hash(v1.hashCode(), v2.hashCode()), PairHash.hash(v3.hashCode(), v4.hashCode()));
    }

    @Override
    public String toString() {
        return "(" + v1 + "," + v2 + "," + v3 + "," + v4 + ")";
    }
}