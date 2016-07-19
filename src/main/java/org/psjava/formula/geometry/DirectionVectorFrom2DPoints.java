package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.math.Vector2D;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class DirectionVectorFrom2DPoints {

    public static <T> Vector2D<T> get(AddableNumberSystem<T> ns, Point2D<T> from, Point2D<T> to) {
        T dx = ns.subtract(to.x(), from.x());
        T dy = ns.subtract(to.y(), from.y());
        return Vector2D.create(dx, dy);
    }

    private DirectionVectorFrom2DPoints() {
    }

}
