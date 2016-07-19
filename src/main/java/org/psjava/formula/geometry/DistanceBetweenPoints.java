package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.DoubleNumberSystem;

public class DistanceBetweenPoints {

    public static double calc(Point2D<Double> p1, Point2D<Double> p2) {
        double sq = DistanceSquareBetweenPoints.calc(DoubleNumberSystem.getInstance(), p1, p2);
        return Math.sqrt(sq);
    }

    private DistanceBetweenPoints() {
    }
}
