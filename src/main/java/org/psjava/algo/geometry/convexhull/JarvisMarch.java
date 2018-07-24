package org.psjava.algo.geometry.convexhull;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.FirstInArray;

import org.psjava.formula.geometry.Point2DMovedByDirection;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.PointByYXComparator;
import org.psjava.ds.geometry.Polygon2D;
import org.psjava.ds.math.Vector2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;
import org.psjava.formula.MinInIterable;
import org.psjava.formula.geometry.DirectionVectorFrom2DPoints;
import org.psjava.formula.geometry.PointByDirectionComparator;
import org.psjava.formula.geometry.PointByDistanceComparator;
import org.psjava.util.Assertion;
import org.psjava.util.ReversedComparator;
import org.psjava.util.SeriesComparator;

/**
 * O(nh)
 */
public class JarvisMarch {

    public static ConvexHullAlgorithm getInstance() {
        return new ConvexHullAlgorithm() {
            @Override
            public <T> Polygon2D<T> calc(Set<Point2D<T>> points, MultipliableNumberSystem<T> ns) {
                Assertion.ensure(!points.isEmpty(), "points must not be empty");
                DynamicArray<Point2D<T>> hull = DynamicArray.create();
                Point2D<T> currentPoint = MinInIterable.min(points, PointByYXComparator.create(ns));
                Vector2D<T> currentDirection = Vector2D.create(ns.getOne(), ns.getZero());
                hull.addToLast(currentPoint);

                while (true) {
                    Point2D<T> nextPoint = findMinimumAnglePoint(points, currentPoint, currentDirection, ns);
                    if (nextPoint == null || nextPoint.equals(FirstInArray.getFirst(hull)))
                        break;

                    hull.addToLast(nextPoint);
                    currentDirection = DirectionVectorFrom2DPoints.get(ns, currentPoint, nextPoint);
                    currentPoint = nextPoint;
                }
                return Polygon2D.create(hull);
            }
        };
    }

    private static <T> Point2D<T> findMinimumAnglePoint(Collection<Point2D<T>> points, Point2D<T> startPoint, Vector2D<T> direction, MultipliableNumberSystem<T> ns) {
        Point2D<T> basis = Point2DMovedByDirection.get(startPoint, direction, ns);
        Comparator<Point2D<T>> comp = SeriesComparator.create(PointByDirectionComparator.create(ns, startPoint, basis), ReversedComparator.wrap(PointByDistanceComparator.create(startPoint, ns)));
        Point2D<T> min = null;
        for (Point2D<T> p : points)
            if (!p.equals(startPoint) && (min == null || comp.compare(p, min) < 0))
                min = p;
        return min;
    }

    private JarvisMarch() {
    }
}
