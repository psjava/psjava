package org.psjava.algo.sequence.rmq;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.sequence.Shuffler;
import org.psjava.ds.array.AddToLastAll;
import org.psjava.ds.array.ArrayFromVarargs;
import org.psjava.ds.array.DynamicArray;
import org.psjava.util.DefaultComparator;
import org.psjava.util.ZeroTo;

public abstract class RangeMinimumQueryTestBase {

    protected abstract RangeMinimumQuery getInstance();

    @Test(expected = RuntimeException.class)
    public void testInvalidRange() {
        RangeMinimumQuerySession session = getInstance().preprocess(ArrayFromVarargs.create(1, 2, 3), new DefaultComparator<Integer>());
        session.getIndex(1, 1);
    }

    @Test
    public void testRandom() {
        int n = 100;
        DynamicArray<Integer> a = DynamicArray.create();
        AddToLastAll.add(a, ZeroTo.get(n));
        Shuffler.shuffle(a);

        RangeMinimumQuerySession session = getInstance().preprocess(a, new DefaultComparator<Integer>());
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++) {
                int minIndex = i;
                for (int k = i; k < j; k++)
                    if (a.get(minIndex) > a.get(k))
                        minIndex = k;
                Assert.assertEquals(session.getIndex(i, j), minIndex);
            }
    }

}
