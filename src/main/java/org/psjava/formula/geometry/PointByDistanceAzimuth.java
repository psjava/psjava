package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Azimuth;
import org.psjava.ds.geometry.Point2D;

public class PointByDistanceAzimuth {

    public static Point2D<Double> calc(double d, Azimuth a) {
        double x = d * Math.cos(a.radian());
        double y = d * Math.sin(a.radian());
        return Point2D.create(x, y);
    }

    private PointByDistanceAzimuth() {
    }
}
