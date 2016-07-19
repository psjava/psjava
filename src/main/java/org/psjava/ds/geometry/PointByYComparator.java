package org.psjava.ds.geometry;

import java.util.Comparator;

public class PointByYComparator {

    public static <T> Comparator<Point2D<T>> create(final Comparator<T> comaprator) {
        return new Comparator<Point2D<T>>() {
            @Override
            public int compare(Point2D<T> p1, Point2D<T> p2) {
                return comaprator.compare(p1.y(), p2.y());
            }
        };
    }

    private PointByYComparator() {
    }
}