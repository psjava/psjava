package org.psjava.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.KeyValuePairEqualityTester;

public class KeyValuePairEqualityTesterTest {

    @Test
    public void testNullValue() {
        Assert.assertTrue(KeyValuePairEqualityTester.are(create(1, null), create(1, null)));
        Assert.assertFalse(KeyValuePairEqualityTester.are(create(1, null), create(1, 2)));
        Assert.assertFalse(KeyValuePairEqualityTester.are(create(1, 2), create(1, null)));
    }

    private static KeyValuePair<Integer, Integer> create(final Integer k, final Integer v) {
        return new KeyValuePair<Integer, Integer>() {
            @Override
            public Integer getKey() {
                return k;
            }

            @Override
            public Integer getValue() {
                return v;
            }
        };
    }
}
