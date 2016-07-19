package org.psjava.util;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.Collection;
import org.psjava.ds.array.ArrayFromVarargs;

public class MergedCollectionTest {
    @Test
    public void test() {
        Collection<Integer> c1 = ArrayFromVarargs.create(1, 2);
        Collection<Integer> c2 = ArrayFromVarargs.create(3, 4);
        @SuppressWarnings("unchecked")
        Collection<Integer> merged = MergedCollection.wrap(ArrayFromVarargs.create(c1, c2));
        Assert.assertEquals(4, merged.size());
        Assert.assertFalse(merged.isEmpty());
        Assert.assertEquals("(1,2,3,4)", merged.toString());
    }
}
