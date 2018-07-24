package org.psjava.algo.geometry.convexhull;

import org.psjava.formula.MinIndexInArray;
import org.psjava.algo.sequence.sort.SortingAlgorithm;
import org.psjava.algo.sequence.sort.SortingHelper;
import org.psjava.ds.array.ArraySwapper;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.FirstInArray;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromIterable;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.PointByYXComparator;
import org.psjava.ds.geometry.Polygon2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;
import org.psjava.formula.geometry.PointByDirectionComparator;
import org.psjava.formula.geometry.LeftTurn;
import org.psjava.formula.geometry.PointByDistanceComparator;
import org.psjava.util.Assertion;
import org.psjava.util.SeriesComparator;

import java.util.Comparator;
import java.util.Set;

/**
 * O(nlogn)
 */
public class GrahamScan {

    public static ConvexHullAlgorithm getInstance(final SortingAlgorithm sortingAlgorithm) {
        return new ConvexHullAlgorithm() {
            @Override
            public <T> Polygon2D<T> calc(Set<Point2D<T>> src, MultipliableNumberSystem<T> ns) {
                Assertion.ensure(!src.isEmpty(), "points must not be empty");
                MutableArray<Point2D<T>> points = MutableArrayFromIterable.create(src);
                int pivotIndex = findPivot(points, ns);
                moveToFront(points, pivotIndex);
                sortByDirectionBasedOnFirstPoint(sortingAlgorithm, points, ns);
                return extractConvexHull(points, ns);
            }
        };
    }

    private static <T> int findPivot(MutableArray<Point2D<T>> p, Comparator<T> comp) {
        return MinIndexInArray.get(p, PointByYXComparator.create(comp));
    }

    private static <T> void moveToFront(MutableArray<Point2D<T>> points, int indexToMove) {
        ArraySwapper.swap(points, 0, indexToMove);
    }

    @SuppressWarnings("unchecked")
    private static <T> void sortByDirectionBasedOnFirstPoint(SortingAlgorithm sa, MutableArray<Point2D<T>> points, MultipliableNumberSystem<T> ns) {
        Point2D<T> first = FirstInArray.getFirst(points);
        Point2D<T> basis = Point2D.create(ns.add(first.x(), ns.getOne()), first.y());
        Comparator<Point2D<T>> comparatorByFirstPoint = SeriesComparator.create(PointByDirectionComparator.create(ns, first, basis), PointByDistanceComparator.create(first, ns));
        SortingHelper.sort(sa, points, 1, points.size(), comparatorByFirstPoint);
    }

    private static <T> Polygon2D<T> extractConvexHull(MutableArray<Point2D<T>> sortedPoints, MultipliableNumberSystem<T> ns) {
        DynamicArray<Point2D<T>> hull = new DynamicArray<Point2D<T>>();
        for (Point2D<T> newPoint : sortedPoints) {
            while (canRemoveLastPoint(hull, newPoint, ns))
                hull.removeLast();
            hull.addToLast(newPoint);
        }
        return Polygon2D.create(hull);
    }

    private static <T> boolean canRemoveLastPoint(MutableArray<Point2D<T>> hull, Point2D<T> newPoint, MultipliableNumberSystem<T> ns) {
        // not only right turning case, also the point on a straight line should be removed.
        return hull.size() >= 2 && !LeftTurn.is(hull.get(hull.size() - 2), hull.get(hull.size() - 1), newPoint, ns);
    }

    private GrahamScan() {
    }
}
