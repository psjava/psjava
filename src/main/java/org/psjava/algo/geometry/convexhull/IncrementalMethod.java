package org.psjava.algo.geometry.convexhull;

import org.psjava.algo.sequence.sort.SortingAlgorithm;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.FirstInArray;
import org.psjava.ds.array.LastInArray;

import org.psjava.ds.array.MergedArray;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromIterable;
import org.psjava.ds.array.ReversedArray;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.PointByXComparator;
import org.psjava.ds.geometry.PointByYComparator;
import org.psjava.ds.geometry.Polygon2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;
import org.psjava.formula.geometry.LeftTurn;
import org.psjava.util.Assertion;
import org.psjava.util.ReversedComparator;
import org.psjava.util.SeriesComparator;

import java.util.Set;

/**
 * O(nlogn)
 */
public class IncrementalMethod {

    public static ConvexHullAlgorithm getInstance(final SortingAlgorithm sortAlgorithm) {
        return new ConvexHullAlgorithm() {
            @Override
            public <T> Polygon2D<T> calc(Set<Point2D<T>> src, MultipliableNumberSystem<T> ns) {
                Assertion.ensure(!src.isEmpty(), "src must not be empty");
                if (src.size() == 1)
                    return Polygon2D.create(src);
                MutableArray<Point2D<T>> array = MutableArrayFromIterable.create(src);
                sortAlgorithm.sort(array, SeriesComparator.create(ReversedComparator.wrap(PointByXComparator.create(ns)), PointByYComparator.create(ns)));
                DynamicArray<Point2D<T>> upHull = getLeftTurningHalfHullFromFirstPoint(array, ns);
                DynamicArray<Point2D<T>> downHull = getLeftTurningHalfHullFromFirstPoint(ReversedArray.wrap(array), ns);
                adjustToPreventDuplication(upHull, downHull);
                return Polygon2D.create(MergedArray.wrap(upHull, downHull));
            }
        };
    }

    private static <T> DynamicArray<Point2D<T>> getLeftTurningHalfHullFromFirstPoint(PSArray<Point2D<T>> order, MultipliableNumberSystem<T> ns) {
        DynamicArray<Point2D<T>> result = DynamicArray.create();
        result.addToLast(FirstInArray.getFirst(order));
        for (Point2D<T> newPoint : order) {
            while (canRemoveLastPoint(result, newPoint, ns))
                result.removeLast();
            result.addToLast(newPoint);
        }
        return result;
    }

    private static <T> boolean canRemoveLastPoint(PSArray<Point2D<T>> array, Point2D<T> newPoint, MultipliableNumberSystem<T> ns) {
        return array.size() >= 2 && !LeftTurn.is(array.get(array.size() - 2), LastInArray.getLast(array), newPoint, ns);
    }

    private static <T> void adjustToPreventDuplication(DynamicArray<Point2D<T>> upHull, DynamicArray<Point2D<T>> downHull) {
        if (upHull.size() >= 2) {
            upHull.removeLast();
            downHull.removeLast();
        }
    }

    private IncrementalMethod() {
    }
}
