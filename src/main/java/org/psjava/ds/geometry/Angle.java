package org.psjava.ds.geometry;

import org.psjava.goods.GoodLongHash;
import org.psjava.StrictEqualityTester;

public class Angle {

    public static Angle create(double radian) {
        return new Angle(radian);
    }

    private final double radian;

    private Angle(double a) {
        this.radian = a;
    }

    public double radian() {
        return radian;
    }

    @Override
    public String toString() {
        return "A" + radian;
    }

    @Override
    public boolean equals(Object o) {
        return StrictEqualityTester.areEqual(this, o, (o1, o2) -> o1.radian == o2.radian);
    }

    @Override
    public int hashCode() {
        return GoodLongHash.hash(Double.doubleToLongBits(radian));
    }

}
