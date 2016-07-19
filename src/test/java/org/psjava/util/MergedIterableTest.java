package org.psjava.util;

import static org.junit.Assert.*;
import static org.psjava.TestUtil.toArrayList;
import static org.psjava.TestUtil.toArrayListFromIterable;

import java.util.ArrayList;

import org.junit.Test;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.MutableArrayFromVarargs;

public class MergedIterableTest {

    @Test
    public void testMerging() {
        DynamicArray<Iterable<Integer>> data = DynamicArray.create();
        data.addToLast(MutableArrayFromVarargs.create(1, 2));
        data.addToLast(new ArrayList<Integer>());
        data.addToLast(MutableArrayFromVarargs.create(4, 5));

        Iterable<Integer> merged = MergedIterable.wrap(data);

        assertEquals(toArrayList(1, 2, 4, 5), toArrayListFromIterable(merged));
    }

    @Test
    public void testEmpty() {
        DynamicArray<Iterable<Integer>> iterables = DynamicArray.create();
        iterables.addToLast(new ArrayList<Integer>());
        iterables.addToLast(new ArrayList<Integer>());
        Iterable<Integer> merged = MergedIterable.wrap(iterables);
        assertEquals(new ArrayList<Integer>(), toArrayListFromIterable(merged));
    }

}
