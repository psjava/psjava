package org.psjava.formula.geometry;

import org.psjava.ds.array.PSArray;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.Polygon2D;
import org.psjava.ds.geometry.Segment2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;
import org.psjava.util.ZeroTo;

public class PointOnPolygon2D {

    public static <T> boolean isOn(Point2D<T> point, Polygon2D<T> polygon, MultipliableNumberSystem<T> ns) {
        PSArray<Point2D<T>> points = polygon.getCCWOrderPoints();
        if (points.size() == 1)
            return point.equals(points.get(0));
        for (int i : ZeroTo.get(points.size())) {
            Point2D<T> p1 = points.get(i);
            Point2D<T> p2 = points.get((i + 1) % points.size());
            if (PointOnSegment2D.isOn(point, Segment2D.create(p1, p2), ns))
                return true;
        }
        return false;
    }

}
