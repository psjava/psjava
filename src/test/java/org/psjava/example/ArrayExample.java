package org.psjava.example;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.ArrayFromValues;
import org.psjava.ds.array.CharacterArrayUsingString;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFactory;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.ds.array.MutableArrayUsingCharArray;
import org.psjava.ds.array.MutableArrayUsingIntArray;
import org.psjava.ds.array.SubArray;
import org.psjava.ds.array.UniformArray;

public class ArrayExample {

	@Test
	public void example() {

		// Array is a simple data structure..

		MutableArray<String> array = MutableArrayFactory.create(10, "");
		array.set(0, "A"); // 0 indexed one is the first value
		array.set(9, "B"); // last value
		String first = array.get(0); // must be "A"
		int size = array.size(); // 10

		// There are several ways to create mutable arrays.

		MutableArrayFromValues.create("A", "B", "C", "D");
		MutableArrayUsingIntArray.wrap(new int[] { 1, 2, 3, 4 }); // There are wrappers for Java arrays.
		MutableArrayUsingCharArray.wrap(new char[] { 'A', 'B', 'C' });

		// Array is read-only interface. there are also several ways to create them.

		ArrayFromValues.create("A", "B", "C");
		CharacterArrayUsingString.create("ABC");
		UniformArray.create("A", 3);
		SubArray.wrap(ArrayFromValues.create("A", "B", "C"), 0, 2); // wraps as 2 sized array ("A", "B")

		// assertions.
		Assert.assertEquals("A", first);
		Assert.assertEquals(10, size);
	}

}
