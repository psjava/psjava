package org.psjava.ds.geometry;

import java.util.Comparator;

import org.psjava.util.SeriesComparator;

public class PointByXYComparator {

    @SuppressWarnings("unchecked")
    public static <T> Comparator<Point2D<T>> create(Comparator<T> comp) {
        return SeriesComparator.create(PointByXComparator.create(comp), PointByYComparator.create(comp));
    }

    private PointByXYComparator() {
    }

}