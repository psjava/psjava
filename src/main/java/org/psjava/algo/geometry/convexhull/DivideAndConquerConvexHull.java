package org.psjava.algo.geometry.convexhull;

import java.util.Comparator;
import java.util.Set;

import org.psjava.IntPair;
import org.psjava.ds.array.MergedArray;
import org.psjava.ds.array.RotatedArray;
import org.psjava.formula.geometry.StraightOrder;
import org.psjava.formula.geometry.RightTurn;
import org.psjava.formula.MinIndexInArray;
import org.psjava.algo.sequence.sort.SortingAlgorithm;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromIterable;
import org.psjava.ds.array.SubArray;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.PointByXComparator;
import org.psjava.ds.geometry.PointByYComparator;
import org.psjava.ds.geometry.Polygon2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;
import org.psjava.formula.geometry.LeftTurn;
import org.psjava.util.Assertion;
import org.psjava.util.ReversedComparator;
import org.psjava.util.SeriesComparator;

import org.psjava.formula.MaxIndexInArray;

/**
 * O(nlogn)
 */
public class DivideAndConquerConvexHull {

    public static ConvexHullAlgorithm getInstance(final SortingAlgorithm sortingAlgorithm) {
        return new ConvexHullAlgorithm() {
            @Override
            public <T> Polygon2D<T> calc(Set<Point2D<T>> src, MultipliableNumberSystem<T> ns) {
                Assertion.ensure(!src.isEmpty(), "points must not be empty");
                Comparator<Point2D<T>> xcomp = PointByXComparator.create(ns);
                Comparator<Point2D<T>> ycomp = PointByYComparator.create(ns);
                Comparator<Point2D<T>> xycomp = SeriesComparator.create(xcomp, ycomp);
                Comparator<Point2D<T>> xrycomp = SeriesComparator.create(xcomp, ReversedComparator.wrap(ycomp));
                MutableArray<Point2D<T>> array = MutableArrayFromIterable.create(src);
                sortingAlgorithm.sort(array, xycomp);
                PSArray<Point2D<T>> hullPoints = getConvexHullPointsRecursively(array, 0, array.size(), xycomp, xrycomp, ns);
                return Polygon2D.create(hullPoints);
            }
        };
    }

    private static <T> PSArray<Point2D<T>> getConvexHullPointsRecursively(PSArray<Point2D<T>> src, int start, int end, Comparator<Point2D<T>> xycomp, Comparator<Point2D<T>> xrycomp, MultipliableNumberSystem<T> ns) {
        if (end - start <= 2)
            return SubArray.wrap(src, start, end);
        int m = (start + end) / 2;
        PSArray<Point2D<T>> left = getConvexHullPointsRecursively(src, start, m, xycomp, xrycomp, ns);
        PSArray<Point2D<T>> right = getConvexHullPointsRecursively(src, m, end, xycomp, xrycomp, ns);
        return merge(left, right, xycomp, xrycomp, ns);
    }

    private static <T> PSArray<Point2D<T>> merge(PSArray<Point2D<T>> left, PSArray<Point2D<T>> right, Comparator<Point2D<T>> xycomp, Comparator<Point2D<T>> xrycomp, MultipliableNumberSystem<T> ns) {
        int leftUp = MaxIndexInArray.get(left, xycomp);
        int leftDown = MaxIndexInArray.get(left, xrycomp);
        int rightUp = MinIndexInArray.get(right, xrycomp);
        int rightDown = MinIndexInArray.get(right, xycomp);
        IntPair upIndex = findBridgeIndexes(right, left, rightUp, leftUp, ns);
        IntPair downIndex = findBridgeIndexes(left, right, leftDown, rightDown, ns);
        PSArray<Point2D<T>> leftHalf = wrapToRotatingSubArray(left, upIndex.v2, downIndex.v1);
        PSArray<Point2D<T>> rightHalf = wrapToRotatingSubArray(right, downIndex.v2, upIndex.v1);
        PSArray<Point2D<T>> hullPoints = getPointsWithoutOnLine(MergedArray.wrap(leftHalf, rightHalf), ns);
        return hullPoints;
    }

    // early, later are ordered by ccw order.
    private static <T> IntPair findBridgeIndexes(PSArray<Point2D<T>> earlyHull, PSArray<Point2D<T>> laterHull, int earlyStart, int laterStart, MultipliableNumberSystem<T> ns) {
        int early = earlyStart;
        int later = laterStart;
        while (true) {
            int nextEarly = getPreIndex(early, earlyHull.size());
            int nextLater = getNextIndex(later, laterHull.size());
            if (LeftTurn.is(laterHull.get(later), earlyHull.get(early), earlyHull.get(nextEarly), ns))
                early = nextEarly;
            else if (RightTurn.is(earlyHull.get(early), laterHull.get(later), laterHull.get(nextLater), ns))
                later = nextLater;
            else
                break;
        }
        return new IntPair(early, later);
    }

    private static <T> PSArray<Point2D<T>> getPointsWithoutOnLine(PSArray<Point2D<T>> src, MultipliableNumberSystem<T> ns) {
        if (src.size() < 3)
            return src;
        DynamicArray<Point2D<T>> r = DynamicArray.create();
        int n = src.size();
        for (int i = 0; i < n; i++) {
            Point2D<T> pre = src.get(getPreIndex(i, n));
            Point2D<T> next = src.get(getNextIndex(i, n));
            if (!StraightOrder.is(pre, src.get(i), next, ns))
                r.addToLast(src.get(i));
        }
        return r;
    }

    private static int getNextIndex(int index, int size) {
        return (index + 1) % size;
    }

    private static int getPreIndex(int index, int size) {
        return (index - 1 + size) % size;
    }

    private static <T> PSArray<T> wrapToRotatingSubArray(PSArray<T> a, int from, int to) {
        int length = (to - from + a.size()) % a.size() + 1;
        return SubArray.wrap(RotatedArray.wrap(a, from), 0, length);
    }

    private DivideAndConquerConvexHull() {
    }
}
