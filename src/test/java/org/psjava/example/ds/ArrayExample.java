package org.psjava.example.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.ArrayFromVarargs;
import org.psjava.ds.array.CharacterArrayUsingString;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFactory;
import org.psjava.ds.array.MutableArrayFromVarargs;
import org.psjava.ds.array.MutableArrayUsingCharArray;
import org.psjava.ds.array.MutableArrayUsingIntArray;
import org.psjava.ds.array.MutableArrayUsingJavaArray;
import org.psjava.ds.array.SubArray;
import org.psjava.ds.array.UniformArray;

/**
 * @implementation {@link MutableArrayUsingJavaArray}
 * @see {@link DynamicArrayExample}
 */
public class ArrayExample {

    @Test
    public void example() {

        // Array interface has only methods for reading.
        // Use MutableArray for modification.

        MutableArray<String> array = MutableArrayFactory.create(10, "");
        array.set(0, "A"); // 0 indexed element is the first value
        array.set(9, "B"); // set last value
        String first = array.get(0); // must be "A"
        int size = array.size(); // 10

        // There are several ways to create mutable arrays.

        MutableArrayFromVarargs.create("A", "B", "C", "D");
        MutableArrayUsingIntArray.wrap(new int[]{1, 2, 3, 4}); // There are wrappers for Java's array.
        MutableArrayUsingCharArray.wrap(new char[]{'A', 'B', 'C'});

        // There are also several ways to create read only array.

        ArrayFromVarargs.create("A", "B", "C");
        CharacterArrayUsingString.wrap("ABC");
        UniformArray.create("A", 3);
        SubArray.wrap(array, 3, 5); // wraps as 2 sized array

        Assert.assertEquals("A", first);
        Assert.assertEquals(10, size);
    }

}
