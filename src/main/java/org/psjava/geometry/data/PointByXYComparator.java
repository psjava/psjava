package org.psjava.geometry.data;

import java.util.Comparator;

import org.psjava.javautil.SeriesComparator;

public class PointByXYComparator {
	
	public static <T> Comparator<Point2D<T>> create(Comparator<T> comp) {
		@SuppressWarnings("unchecked")
		final Comparator<Point2D<T>> series = SeriesComparator.create(PointByXComparator.create(comp), PointByYComparator.create(comp));
		return new Comparator<Point2D<T>>() {
			@Override
			public int compare(Point2D<T> o1, Point2D<T> o2) {
				return series.compare(o1, o2);
			}
		};
	}

}