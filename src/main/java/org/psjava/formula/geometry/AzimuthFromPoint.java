package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Azimuth;
import org.psjava.ds.geometry.Point2D;

public class AzimuthFromPoint {

    public static Azimuth calc(Point2D<Double> p, Point2D<Double> ref) {
        double y = p.y() - ref.y();
        double x = p.x() - ref.x();
        if (x == 0 && y == 0)
            throw new IllegalArgumentException("same points");
        return Azimuth.create(Math.atan2(y, x));
    }

    private AzimuthFromPoint() {
    }

}
