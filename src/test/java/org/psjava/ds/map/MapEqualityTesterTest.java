package org.psjava.ds.map;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class MapEqualityTesterTest {

    @Test
    public void test() throws Exception {
        MutableMap<Integer, Integer> m1 = MutableMapUsingJavaMap.wrap(new HashMap<Integer, Integer>());
        MutableMap<Integer, Integer> m2 = MutableMapUsingJavaMap.wrap(new HashMap<Integer, Integer>());
        int[] k = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < k.length; i++)
            m1.add(k[i], k[i]);
        for (int i = k.length - 1; i >= 0; i--)
            m2.add(k[i], k[i]);
        Assert.assertTrue(MapEqualityTester.areEqual(m1, m2));
    }
}
