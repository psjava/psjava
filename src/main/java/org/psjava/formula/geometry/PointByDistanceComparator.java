package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;

import java.util.Comparator;

public class PointByDistanceComparator {

    public static <T> Comparator<Point2D<T>> create(final Point2D<T> ref, final MultipliableNumberSystem<T> ns) {
        return new Comparator<Point2D<T>>() {
            @Override
            public int compare(Point2D<T> p1, Point2D<T> p2) {
                return ns.compare(calcDistanceSquare(p1), calcDistanceSquare(p2));
            }

            private T calcDistanceSquare(Point2D<T> p) {
                return DistanceSquareBetweenPoints.calc(ns, ref, p);
            }
        };
    }

    private PointByDistanceComparator() {
    }

}