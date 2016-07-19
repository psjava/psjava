package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.Segment2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;

public class PointOnSegment2D {

    public static <T> boolean isOn(Point2D<T> p, Segment2D<T> s, MultipliableNumberSystem<T> ns) {
        return StraightOrder.is(s.p1(), p, s.p2(), ns);
    }

}
