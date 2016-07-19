package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.Segment2D;
import org.psjava.ds.math.Vector2D;
import org.psjava.ds.numbersystrem.DivisableNumberSystem;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;
import org.psjava.formula.InRange;
import org.psjava.formula.numerical.CrossProduct2D;

public class IntersectionOfNonParallelSegments {

    public static <T> Point2D<T> calc(DivisableNumberSystem<T> ns, Segment2D<T> s1, Segment2D<T> s2, Point2D<T> def) {
        // http://stackoverflow.com/questions/563198/how-do-you-detect-where-two-line-segments-intersect
        Point2D<T> p = s1.p1();
        Point2D<T> q = s2.p1();
        Vector2D<T> r = DirectionVectorFrom2DPoints.get(ns, p, s1.p2());
        Vector2D<T> s = DirectionVectorFrom2DPoints.get(ns, q, s2.p2());
        T rxs = CrossProduct2D.calc(ns, r, s);
        if (ns.isZero(rxs))
            throw new IllegalArgumentException("two segments are parallel");

        Vector2D<T> pq = DirectionVectorFrom2DPoints.get(ns, p, q); // p-q
        T t = ns.divide(CrossProduct2D.calc(ns, pq, s), rxs);
        T u = ns.divide(CrossProduct2D.calc(ns, pq, r), rxs);

        if (inZeroToOne(ns, t) && inZeroToOne(ns, u))
            return MiddlePoint.calc(ns, s1.p1(), s1.p2(), t);
        else
            return def;
    }

    private static <T> boolean inZeroToOne(MultipliableNumberSystem<T> ns, T v) {
        return InRange.is(v, ns.getZero(), ns.getOne(), ns);
    }

    private IntersectionOfNonParallelSegments() {
    }

}
