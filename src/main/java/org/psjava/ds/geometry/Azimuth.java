package org.psjava.ds.geometry;

import org.psjava.goods.GoodLongHash;
import org.psjava.StrictEqualityTester;

public class Azimuth {

    private static final double DOUBLE_PI = Math.PI + Math.PI;

    public static Azimuth create(double radian) {
        return new Azimuth(radian);
    }

    private final double radian; // 0 =< a < 2pi

    public Azimuth(double radian) {
        if (Double.isNaN(radian))
            throw new IllegalArgumentException("Direction cannot be NaN");
        this.radian = adjustRadian(radian);
    }

    private double adjustRadian(double radian) {
        radian = radian % DOUBLE_PI;
        if (radian < 0)
            radian += DOUBLE_PI;
        if (radian >= DOUBLE_PI)
            radian = 0;
        return radian;
    }

    public double radian() {
        return radian;
    }

    @Override
    public final boolean equals(Object v) {
        return StrictEqualityTester.areEqual(this, v, (o1, o2) -> o1.radian == o2.radian);
    }

    @Override
    public final int hashCode() {
        return GoodLongHash.hash(Double.doubleToLongBits(radian));
    }

    @Override
    public String toString() {
        return "Azimuth(" + String.format("%.2f", radian) + "pi)";
    }

}
