package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Azimuth;
import org.psjava.ds.geometry.DoublePointOrigin;
import org.psjava.ds.geometry.Point2D;

public class AzimuthFromOrigin {

    public static Azimuth calc(Point2D<Double> p) {
        return AzimuthFromPoint.calc(p, DoublePointOrigin.ORIGIN);
    }

    private AzimuthFromOrigin() {
    }

}
