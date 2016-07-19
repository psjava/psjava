package org.psjava.ds.math;

public class Vector2D<T> {
    private final T x, y;

    public static <T> Vector2D<T> create(T x, T y) {
        return new Vector2D<T>(x, y);
    }

    private Vector2D(T x, T y) {
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
    public String toString() {
        return getClass().getSimpleName() + "(" + x + "," + y + ")";
    }
}
