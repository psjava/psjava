package org.psjava.ds.geometry;

import java.util.Comparator;

public class PointByXComparator {

    public static <T> Comparator<Point2D<T>> create(final Comparator<T> comaprator) {
        return new Comparator<Point2D<T>>() {
            @Override
            public int compare(Point2D<T> p1, Point2D<T> p2) {
                return comaprator.compare(p1.x(), p2.x());
            }
        };
    }

    private PointByXComparator() {
    }
}