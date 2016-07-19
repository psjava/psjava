package org.psjava.ds.map;

import org.junit.Test;
import org.psjava.util.DefaultComparator;

import static org.junit.Assert.*;

public class MutableSortedMapUsingJavaTreeMapTest {
    @Test
    public void test() {
        MutableSortedMap<String, Integer> map = MutableSortedMapUsingJavaTreeMap.<String, Integer>create(new DefaultComparator<String>());
        map.add("A", null);
        assertTrue(map.containsKey("A"));
        assertTrue(map.get("A") == null);
    }
}