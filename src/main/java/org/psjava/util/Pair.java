package org.psjava.util;

import org.psjava.algo.math.PairHash;

public class Pair<T1, T2> implements EqualityTester<Pair<T1, T2>> {

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
        return StrictEqualityTester.areEqual(this, obj, this);
    }

    @Override
    public boolean areEqual(Pair<T1, T2> o1, Pair<T1, T2> o2) {
        return o1.v1.equals(o2.v1) && o1.v2.equals(o2.v2);
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