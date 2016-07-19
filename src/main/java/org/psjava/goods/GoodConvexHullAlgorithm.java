package org.psjava.goods;

import org.psjava.algo.geometry.convexhull.ConvexHullAlgorithm;
import org.psjava.algo.geometry.convexhull.GrahamScan;

public class GoodConvexHullAlgorithm {

    public static ConvexHullAlgorithm getInstance() {
        return GrahamScan.getInstance(GoodSortingAlgorithm.getInstance());
    }

    private GoodConvexHullAlgorithm() {
    }
}
