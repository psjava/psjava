package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;

public class StraightOrder {
    public static <T> boolean is(Point2D<T> x1, Point2D<T> x2, Point2D<T> x3, MultipliableNumberSystem<T> ns) {
        T ccw = CCW.ccw(ns, x1, x2, x3);
        return org.psjava.formula.geometry.StraightOrderFromCCW.is(ns, x1, x2, x3, ccw);
    }
}
