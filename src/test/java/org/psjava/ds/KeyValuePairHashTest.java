package org.psjava.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.KeyValuePairHash;

public class KeyValuePairHashTest {

    @Test
    public void test() {
        int r = KeyValuePairHash.hash(new KeyValuePair<Integer, Integer>() {
            @Override
            public Integer getKey() {
                return 1;
            }

            @Override
            public Integer getValue() {
                return null;
            }
        });
        Assert.assertEquals(1, r);
    }
}
