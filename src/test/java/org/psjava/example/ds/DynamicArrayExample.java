package org.psjava.example.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.DynamicArray;

/**
 * @implementation {@link DynamicArray}
 * @see {@link ArrayExample}
 */
public class DynamicArrayExample {

    @Test
    public void example() {
        // Operations

        DynamicArray<String> array = DynamicArray.create();
        array.addToLast("A");
        array.addToLast("B");
        array.removeLast();
        array.addToLast("C");
        Assert.assertEquals(2, array.size());
    }

}
