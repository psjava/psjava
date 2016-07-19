package org.psjava.formula.geometry;

import java.util.Comparator;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;

public class PointByDirectionComparator {

    public static <T> Comparator<Point2D<T>> create(final MultipliableNumberSystem<T> ns, final Point2D<T> center, final Point2D<T> basis) {
        return new Comparator<Point2D<T>>() {
            @Override
            public int compare(Point2D<T> p1, Point2D<T> p2) {
                int z1 = calcZoneOrder(p1);
                int z2 = calcZoneOrder(p2);
                if (z1 != z2) {
                    return z1 - z2;
                } else { // same zone case
                    if (z1 == 0 || z1 == 2) {
                        return 0;
                    } else {
                        T ccw = CCW.ccw(ns, p1, center, p2);
                        if (RightTurnFromCCW.is(ns, ccw))
                            return -1;
                        else if (LeftTurnFromCCW.is(ns, ccw))
                            return 1;
                        else
                            return 0;
                    }
                }
            }

            int calcZoneOrder(Point2D<T> p) {
                T ccw = CCW.ccw(ns, basis, center, p);
                if (StraightOrderFromCCW.is(ns, basis, center, p, ccw))
                    return 2; // directly opposite from basis.
                else if (RightTurnFromCCW.is(ns, ccw))
                    return 1; // right side from basis
                else if (LeftTurnFromCCW.is(ns, ccw))
                    return 3; // left side from basis
                else
                    return 0; // same direction with basis's
            }

        };
    }

    private PointByDirectionComparator() {
    }

}