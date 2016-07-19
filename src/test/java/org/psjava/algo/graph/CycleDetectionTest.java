package org.psjava.algo.graph;

import static org.junit.Assert.*;

import org.junit.Test;
import org.psjava.ds.graph.TestGraphFactory;

public class CycleDetectionTest {

    @Test
    public void testEmptyGraph() {
        String[][] data = new String[][]{};
        assertFalse(CycleDetection.hasCycle(TestGraphFactory.createDirectedNew(data)));
    }

    @Test
    public void testCycleGraph() {
        String[][] data = new String[][]{{"0", "1"}, {"0", "2"}, {"2", "0"}};
        assertTrue(CycleDetection.hasCycle(TestGraphFactory.createDirectedNew(data)));
    }

    @Test
    public void testSelfCycleGraph() {
        String[][] data = new String[][]{{"1", "1"}};
        assertTrue(CycleDetection.hasCycle(TestGraphFactory.createDirectedNew(data)));
    }

    @Test
    public void testAcycleGraph() {
        String[][] data = new String[][]{{"0", "1"}, {"0", "2"}, {"1", "2"}};
        assertFalse(CycleDetection.hasCycle(TestGraphFactory.createDirectedNew(data)));
    }

}
