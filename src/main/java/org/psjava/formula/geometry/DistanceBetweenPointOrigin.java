package org.psjava.formula.geometry;

import org.psjava.ds.geometry.DoublePointOrigin;
import org.psjava.ds.geometry.Point2D;

public class DistanceBetweenPointOrigin {

    public static double calc(Point2D<Double> p) {
        return DistanceBetweenPoints.calc(p, DoublePointOrigin.ORIGIN);
    }

    private DistanceBetweenPointOrigin() {
    }

}
