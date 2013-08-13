package org.psjava.math;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;
import org.psjava.ds.array.Array;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.javautil.DefaultComparator;

public class MaxInIterableTest {

	@Test
	public void testMax() {
		Array<Integer> a = MutableArrayFromValues.create(1, 3, 2);
		assertEquals(3, (int) MaxInIterable.max(a, COMP));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmpty() {
		MaxInIterable.max(DynamicArray.<Integer>create(), COMP);
	}

	private static final Comparator<Integer> COMP = new DefaultComparator<Integer>();

}
