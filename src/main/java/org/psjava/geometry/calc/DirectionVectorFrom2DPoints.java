package org.psjava.geometry.calc;

import org.psjava.geometry.data.Point2D;
import org.psjava.math.linearalgebra.Vector2D;
import org.psjava.math.ns.AddableNumberSystem;

public class DirectionVectorFrom2DPoints {

	public static <T> Vector2D<T> get(AddableNumberSystem<T> ns, Point2D<T> from, Point2D<T> to) {
		T dx = ns.subtract(to.x(), from.x());
		T dy = ns.subtract(to.y(), from.y());
		return Vector2D.create(dx, dy);
	}

}
