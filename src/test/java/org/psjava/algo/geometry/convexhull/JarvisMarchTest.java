package org.psjava.algo.geometry.convexhull;

public class JarvisMarchTest extends ConvexHullAlgorithmTestBase {

    @Override
    protected ConvexHullAlgorithm getAlgorithm() {
        return JarvisMarch.getInstance();
    }

}
