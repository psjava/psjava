package org.psjava.algo.geometry.convexhull;

import org.psjava.goods.GoodSortingAlgorithm;

public class DivideAndConquerConvexHullTest extends ConvexHullAlgorithmTestBase {

    @Override
    protected ConvexHullAlgorithm getAlgorithm() {
        return DivideAndConquerConvexHull.getInstance(GoodSortingAlgorithm.getInstance());
    }
}
