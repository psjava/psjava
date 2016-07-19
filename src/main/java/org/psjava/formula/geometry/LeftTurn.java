package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;

public class LeftTurn {

    public static <T> boolean is(Point2D<T> p1, Point2D<T> p2, Point2D<T> p3, MultipliableNumberSystem<T> ns) {
        T ccw = CCW.ccw(ns, p1, p2, p3);
        return LeftTurnFromCCW.is(ns, ccw);
    }

    private LeftTurn() {
    }
}
