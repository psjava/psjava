package org.psjava.algo.geometry.convexhull;

import org.psjava.algo.geometry.convexhull.ConvexHullAlgorithm;
import org.psjava.algo.sequence.sort.SortingAlgorithm;
import org.psjava.ds.array.Array;
import org.psjava.ds.array.ArrayReverser;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.FirstInArray;
import org.psjava.ds.array.LastInArray;

import org.psjava.ds.array.MergedArray;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromIterable;
import org.psjava.ds.array.ReversedArray;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.PointByXYComparator;
import org.psjava.ds.geometry.Polygon2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;
import org.psjava.ds.set.Set;
import org.psjava.formula.geometry.LeftTurn;
import org.psjava.util.AssertStatus;

/** O(nlogn) */
public class IncrementalMethod {

	public static ConvexHullAlgorithm getInstance(final SortingAlgorithm sortAlgorithm) {
		return new ConvexHullAlgorithm() {
			@Override
			public <T> Polygon2D<T> calc(Set<Point2D<T>> src, MultipliableNumberSystem<T> ns) {
				AssertStatus.assertTrue(!src.isEmpty(), "src must not be empty");
				if(src.size() == 1)
					return Polygon2D.create(src);
				MutableArray<Point2D<T>> array = MutableArrayFromIterable.create(src);
				sortAlgorithm.sort(array, PointByXYComparator.create(ns));
				DynamicArray<Point2D<T>> upHull = getRightTurningHalfHullFromFirstPoint(array, ns);
				ArrayReverser.reverse(array);
				DynamicArray<Point2D<T>> downHull = getRightTurningHalfHullFromFirstPoint(array, ns);
				adjustToPreventDuplication(upHull, downHull);
				return Polygon2D.create(ReversedArray.wrap(MergedArray.wrap(upHull, downHull)));
			}
		};
	}

	private static <T> DynamicArray<Point2D<T>> getRightTurningHalfHullFromFirstPoint(Array<Point2D<T>> order, MultipliableNumberSystem<T> ns) {
		DynamicArray<Point2D<T>> hull = DynamicArray.create();
		hull.addToLast(FirstInArray.getFirst(order));
		for(Point2D<T> point : order) {
			if (!LastInArray.getLast(hull).equals(point)) {
				while (hull.size() >= 2 && !LeftTurn.is(point, LastInArray.getLast(hull), hull.get(hull.size() - 2), ns))
					hull.removeLast();
				hull.addToLast(point);
			}
		}
		return hull;
	}

	private static <T> void adjustToPreventDuplication(DynamicArray<Point2D<T>> upHull, DynamicArray<Point2D<T>> downHull) {
		if(upHull.size() >= 2) {
			upHull.removeLast();
			downHull.removeLast();
		}
	}

}
