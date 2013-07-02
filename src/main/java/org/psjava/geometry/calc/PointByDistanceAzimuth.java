package org.psjava.geometry.calc;

import org.psjava.geometry.data.Azimuth;
import org.psjava.geometry.data.Point2D;
import org.psjava.math.ns.Float64;


public class PointByDistanceAzimuth {
	
	public static Point2D<Float64> calc(double d, Azimuth a) {
		double x = d * Math.cos(a.radian());
		double y = d * Math.sin(a.radian());
		return Point2D.create(Float64.valueOf(x), Float64.valueOf(y));
	}

}
