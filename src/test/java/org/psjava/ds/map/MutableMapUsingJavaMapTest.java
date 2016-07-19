package org.psjava.ds.map;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MutableMapUsingJavaMapTest {

    @Test
    public void testNullValue() {
        MutableMap<String, Integer> map = MutableMapUsingJavaMap.wrap(new HashMap<String, Integer>());
        map.add("B", null);
        assertTrue(map.containsKey("B"));
        map.replace("B", 1);
    }

    @Test(expected = RuntimeException.class)
    public void testNullValueAndAddFail() {
        MutableMap<String, Integer> map = MutableMapUsingJavaMap.wrap(new HashMap<String, Integer>());
        map.add("B", null);
        map.add("B", 1);
    }

}