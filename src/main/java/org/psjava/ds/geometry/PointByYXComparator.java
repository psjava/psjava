package org.psjava.ds.geometry;

import org.psjava.util.SeriesComparator;

import java.util.Comparator;

public class PointByYXComparator {

    @SuppressWarnings("unchecked")
    public static <T> Comparator<Point2D<T>> create(Comparator<T> comp) {
        return SeriesComparator.create(PointByYComparator.create(comp), PointByXComparator.create(comp));
    }

    private PointByYXComparator() {
    }

}