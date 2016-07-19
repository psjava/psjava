package org.psjava.ds.map.hashtable;

import static org.junit.Assert.*;

import org.junit.Test;
import org.psjava.util.IterableToString;
import org.psjava.util.VarargsIterable;

public class OpenAddressingHashTableMapTest {

    @Test
    public void testCalcBucketSize() {
        assertEquals(1, OpenAddressingHashTableMap.calcBucketSize(0));
        assertEquals(1 << 28, OpenAddressingHashTableMap.calcBucketSize(100000000));
    }

    @Test
    public void testPutToCurrentArray() {
        OpenAddressingHashTableMap<Integer, String> table = create(4);
        Object[][] data = {{1, "A"}, {1, "B"}, {9, "C"}, {17, "D"}};
        putToCurrentArray(table, data);
        assertEquals("(null,1=B,9=C,null,null,17=D,null,null)", toBucketString(table));
        assertEquals(3, table.load);
        table.remove(9);
        assertEquals("(null,1=B,<removed>,null,null,17=D,null,null)", toBucketString(table));
        assertEquals(3, table.load);
        table.add(9, "E");
        assertEquals("(null,1=B,<removed>,9=E,null,17=D,null,null)", toBucketString(table));
        assertEquals(4, table.load);
    }

    @Test
    public void testCapacityExtension() {
        OpenAddressingHashTableMap<Integer, String> table = create(1);
        putToCurrentArray(table, new Object[][]{{2, "A"}, {1, "B"}});
        assertEquals("(2=A,1=B)", toBucketString(table));
        table.ensureArraysCapacity(2);
        assertEquals("(null,1=B,2=A,null)", toBucketString(table));
    }

    @Test
    public void testLazyDeletion() {
        OpenAddressingHashTableMap<Integer, String> table = create(1);
        table.putToCurrentArray(1, "A");
        table.remove(1);
        assertEquals("(null,<removed>)", toBucketString(table));
        table.ensureArraysCapacity(2);
        assertEquals("(null,null,null,null)", toBucketString(table));
    }

    @Test
    public void testAutoExpansionByPut() {
        OpenAddressingHashTableMap<Integer, String> table = create(1);
        table.add(1, "A");
        table.add(2, "B");
        assertEquals("(null,1=A,2=B,null)", toBucketString(table));
    }

    @Test
    public void testFindEntry() {
        OpenAddressingHashTableMap<Integer, String> table = create(2);
        table.add(1, "A");
        assertEquals("A", table.getOrNull(1));
        table.add(5, "B");
        assertEquals("A", table.getOrNull(1));
        assertEquals("B", table.getOrNull(5));
        assertNull(table.getOrNull(2));
    }

    @Test
    public void testSize() {
        OpenAddressingHashTableMap<Integer, Integer> table = create(2);
        table.add(1, 0);
        assertEquals(1, table.size());
        table.add(2, 0);
        assertEquals(2, table.size());
    }

    @Test
    public void testIteration() {
        OpenAddressingHashTableMap<Integer, String> table = create(4);
        putToCurrentArray(table, new Object[][]{{17, "A"}, {1, "B"}, {9, "C"}});
        assertEquals("(17=A,1=B,9=C)", IterableToString.toString(table));
    }

    @Test
    public void testRemove() {
        OpenAddressingHashTableMap<Integer, Integer> table = create(4);
        for (int v : new int[]{1, 9, 17, 25})
            table.putToCurrentArray(v, 0);
        table.remove(9);
        assertEquals(3, table.size());
        assertEquals(1, table.lazyDeletedCount);
    }

    private <K, V> OpenAddressingHashTableMap<K, V> create(int reserve) {
        return new OpenAddressingHashTableMap<K, V>(QuadraticProbing.create(), reserve);
    }

    private static void putToCurrentArray(OpenAddressingHashTableMap<Integer, String> table, Object[][] data) {
        for (Object[] d : data)
            table.putToCurrentArray((Integer) d[0], (String) d[1]);
    }

    private static String toBucketString(OpenAddressingHashTableMap<Integer, String> table) {
        return IterableToString.toString(VarargsIterable.create(table.bucket));
    }

}
