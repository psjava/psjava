package org.psjava.algo.geometry.convexhull;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.sequence.search.LinearSearch;
import org.psjava.ds.SetFromIterableV2;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.RotatedArray;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.Polygon2D;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.util.IterableEqualityTester;

abstract public class ConvexHullAlgorithmTestBase {

    abstract protected ConvexHullAlgorithm getAlgorithm();

    @Test(expected = RuntimeException.class)
    public void testEmpty() {
        testAndAssert(new int[][]{}, new int[][]{});
    }

    @Test
    public void testOnePoint() {
        testAndAssert(new int[][]{{10, 10}}, new int[][]{{10, 10}});
    }

    @Test
    public void testDuplicatedOnePoint() {
        testAndAssert(new int[][]{{10, 10}}, new int[][]{{10, 10}, {10, 10}});
    }

    @Test
    public void testTwoPoints() {
        testAndAssert(new int[][]{{-10, -10}, {10, 10}}, new int[][]{{-10, -10}, {10, 10}});
    }

    @Test
    public void testTriangle() {
        int[][] d = new int[][]{{10, 10}, {-10, 10}, {-10, -10}};
        testAndAssert(d, d);
    }

    @Test
    public void testPointOnSegment() {
        testAndAssert(new int[][]{{2, 0}, {0, 2}, {-2, 0}, {0, -2}}, new int[][]{{2, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}, {-2, 0}, {0, -2}, {0, 2}});
    }

    @Test
    public void testDuplicatedPoint() {
        testAndAssert(new int[][]{{2, 0}, {0, 2}, {-2, 0}, {0, -2}}, new int[][]{{2, 0}, {0, 2}, {-2, 0}, {0, -2}, {2, 0}, {0, 2}, {-2, 0}, {0, -2}, {0, 0}, {0, 0}});
    }

    @Test
    public void testGeneral() {
        testAndAssert(new int[][]{{2, 3}, {6, 1}, {7, 2}, {9, 5}, {9, 8}, {5, 9}, {2, 7}}, new int[][]{{2, 3}, {2, 7}, {4, 2}, {6, 1}, {3, 6}, {4, 5}, {5, 6}, {5, 9}, {6, 3}, {6, 4}, {7, 2}, {7, 7}, {9, 5}, {9, 8}});
    }

    @Test
    public void testFirstIsNotConvexHull() {
        testAndAssert(new int[][]{{2, 5}, {10, 5}, {10, 10}, {2, 10}}, new int[][]{{5, 5}, {10, 5}, {10, 10}, {2, 10}, {2, 5}});
    }

    public void testAndAssert(int[][] expectedPairs, int[][] data) {
        PSArray<Point2D<Integer>> expected = toPoints(expectedPairs);
        Polygon2D<Integer> actual = getAlgorithm().calc(SetFromIterableV2.create(toPoints(data)), IntegerNumberSystem.getInstance());
        int index = LinearSearch.search(actual.getCCWOrderPoints(), expected.get(0), -1);
        Assert.assertTrue(index != -1);
        PSArray<Point2D<Integer>> adjustedActual = RotatedArray.wrap(actual.getCCWOrderPoints(), index);
        Assert.assertTrue(IterableEqualityTester.areEqual(expected, adjustedActual));
    }

    private PSArray<Point2D<Integer>> toPoints(int[][] expectedHull) {
        DynamicArray<Point2D<Integer>> points = DynamicArray.create();
        for (int[] pair : expectedHull)
            points.addToLast(Point2D.create(pair[0], pair[1]));
        return points;
    }

}
