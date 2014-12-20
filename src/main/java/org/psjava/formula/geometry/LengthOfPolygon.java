package org.psjava.formula.geometry;

import org.psjava.ds.array.Array;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.Polygon2D;
import org.psjava.util.ZeroTo;

public class LengthOfPolygon {

	public static double calc(Polygon2D<Double> polygon) {
		Array<Point2D<Double>> points = polygon.getCCWOrderPoints();
		double sum = 0;
		for (int i : ZeroTo.get(points.size()))
			sum += DistanceBetweenPoints.calc(points.get(i), points.get((i + 1) % points.size()));
		return sum;
	}

}
