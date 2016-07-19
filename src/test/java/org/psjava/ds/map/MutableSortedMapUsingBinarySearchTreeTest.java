package org.psjava.ds.map;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.util.DefaultComparator;

public class MutableSortedMapUsingBinarySearchTreeTest {
    @Test
    public void testAdd() {
        MutableSortedMap<Integer, Integer> map = create();
        map.add(1, 100);
        map.add(3, 300);
        map.add(2, 200);
        Assert.assertEquals("(1=100,2=200,3=300)", map.toString());
    }

    @Test
    public void testSize() {
        MutableSortedMap<Integer, Integer> map = create();
        map.add(1, 100);
        map.add(2, 100);
        map.replace(1, 200);
        Assert.assertEquals(2, map.size());
    }

    @Test
    public void testAllowingNullValue() {
        MutableSortedMap<Integer, Integer> map = create();
        map.add(1, null);
        Assert.assertTrue(map.containsKey(1));
        Assert.assertTrue(map.get(1) == null);
    }

    private MutableSortedMap<Integer, Integer> create() {
        return MutableSortedMapUsingBinarySearchTree.<Integer, Integer>create(new DefaultComparator<Integer>());
    }

}
