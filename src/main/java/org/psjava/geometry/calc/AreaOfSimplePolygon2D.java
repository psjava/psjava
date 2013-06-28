package org.psjava.geometry.calc;

import org.psjava.geometry.data.Point2D;
import org.psjava.geometry.data.Polygon2D;
import org.psjava.javautil.ZeroTo;
import org.psjava.math.Abs;
import org.psjava.math.ns.DivisableNumberSystem;
import org.psjava.math.ns.MultipliableNumberSystem;

public class AreaOfSimplePolygon2D {
	
	// TODO assert simplicity

	public static <T> T calc(DivisableNumberSystem<T> ns, Polygon2D<T> sp) {
		T two = ns.add(ns.getOne(), ns.getOne());
		return ns.divide(calcDouble(ns, sp), two);
	}

	private static <T> T calcDouble(MultipliableNumberSystem<T> ns, Polygon2D<T> sp) {
		T total = ns.getZero();
		for (int i : ZeroTo.get(sp.pointNumber())) {
			Point2D<T> p1 = sp.get(i);
			Point2D<T> p2 = sp.get((i + 1) % sp.pointNumber());
			total = ns.add(total, ns.subtract(ns.multiply(p1.x(), p2.y()), ns.multiply(p1.y(), p2.x())));
		}
		return Abs.calc(ns, total);
	}

}
