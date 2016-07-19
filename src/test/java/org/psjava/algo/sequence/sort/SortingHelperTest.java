package org.psjava.algo.sequence.sort;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.TestUtil;
import org.psjava.algo.sequence.sort.SortingHelper;
import org.psjava.ds.array.DynamicArray;
import org.psjava.goods.GoodSortingAlgorithm;

public class SortingHelperTest {

    @Test
    public void test() {
        DynamicArray<Integer> d = DynamicArray.create();
        for (int v : new int[]{4, 3, 1, 2})
            d.addToLast(v);
        SortingHelper.sort(GoodSortingAlgorithm.getInstance(), d, 1, 3);
        Assert.assertEquals(TestUtil.toArrayList(4, 1, 3, 2), TestUtil.toArrayListFromIterable(d));
    }

}
