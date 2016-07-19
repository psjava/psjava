package org.psjava.algo.geometry.convexhull;

import org.psjava.algo.geometry.convexhull.ConvexHullAlgorithm;
import org.psjava.algo.geometry.convexhull.GrahamScan;
import org.psjava.goods.GoodSortingAlgorithm;

public class GrahamScanTest extends ConvexHullAlgorithmTestBase {

    @Override
    protected ConvexHullAlgorithm getAlgorithm() {
        return GrahamScan.getInstance(GoodSortingAlgorithm.getInstance());
    }
}
