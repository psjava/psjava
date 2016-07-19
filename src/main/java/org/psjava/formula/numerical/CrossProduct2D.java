package org.psjava.formula.numerical;

import org.psjava.ds.math.Vector2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;

public class CrossProduct2D {

    public static <T> T calc(MultipliableNumberSystem<T> ns, Vector2D<T> d1, Vector2D<T> d2) {
        T x1y2 = ns.multiply(d1.x(), d2.y());
        T y1x2 = ns.multiply(d1.y(), d2.x());
        return ns.subtract(x1y2, y1x2);
    }

    private CrossProduct2D() {
    }

}
