package org.psjava.algo.math;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;
import org.psjava.algo.math.MaxInIterable;
import org.psjava.ds.array.Array;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.util.DefaultComparator;

public class MaxInIterableTest {

	private static final Comparator<Integer> COMP = new DefaultComparator<Integer>();

	@Test
	public void testMax() {
		Array<Integer> a = MutableArrayFromValues.create(1, 3, 2);
		assertEquals(3, (int) MaxInIterable.max(a, COMP));
	}

	@Test(expected = RuntimeException.class)
	public void testEmpty() {
		MaxInIterable.max(DynamicArray.<Integer> create(), COMP);
	}

}
