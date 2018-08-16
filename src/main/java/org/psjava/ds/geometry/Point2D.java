package org.psjava.ds.geometry;

import org.psjava.StrictEqualityTester;

public class Point2D<T> {

    public static <T> Point2D<T> create(T x, T y) {
        return new Point2D<T>(x, y);
    }

    private final T x;
    private final T y;

    private Point2D(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T x() {
        return x;
    }

    public T y() {
        return y;
    }

    @Override
    public final boolean equals(Object o) {
        return StrictEqualityTester.areEqual(this, o, (a, b) -> a.x.equals(b.x) && a.y.equals(b.y));
    }

    public final int hashCode() {
        return x.hashCode() ^ y.hashCode();
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
