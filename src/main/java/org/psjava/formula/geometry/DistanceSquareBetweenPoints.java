package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;
import org.psjava.formula.Square;

public class DistanceSquareBetweenPoints {

    public static <T> T calc(MultipliableNumberSystem<T> ns, Point2D<T> p1, Point2D<T> p2) {
        T dxSq = Square.calc(ns, ns.subtract(p1.x(), p2.x()));
        T dySq = Square.calc(ns, ns.subtract(p1.y(), p2.y()));
        return ns.add(dxSq, dySq);
    }

    private DistanceSquareBetweenPoints() {
    }

}
