package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class StraightOrderFromCCW {

    public static <T> boolean is(AddableNumberSystem<T> ns, Point2D<T> p1, Point2D<T> p2, Point2D<T> p3, T ccw) {
        return ns.isZero(ccw) && PointOnFilledRectangle.isOn(p2, p1.x(), p3.x(), p1.y(), p3.y(), ns);
    }

    private StraightOrderFromCCW() {
    }

}
