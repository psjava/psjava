package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.math.Vector2D;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class Point2DMovedByDirection {

    public static <T> Point2D<T> get(Point2D<T> p, Vector2D<T> directionVector, AddableNumberSystem<T> ns) {
        T nx = ns.add(directionVector.x(), p.x());
        T ny = ns.add(directionVector.y(), p.y());
        return Point2D.create(nx, ny);
    }

    private Point2DMovedByDirection() {
    }

}
