package org.psjava.javautil;

import static org.junit.Assert.*;
import static org.psjava.TestUtil.toArrayList;
import static org.psjava.TestUtil.toArrayListFromIterable;

import org.junit.Test;
import org.psjava.javautil.FilteredIterable;

public class FilteredIterableTest {

	@Test
	public void testCreate() {
		assertEquals(toArrayList(2,4), toArrayListFromIterable(FilteredIterable.create(toArrayList(1,2,3,4,5), new DataFilter<Integer>() {
			@Override
			public boolean isAccepted(Integer v) {
				return v % 2 == 0;
			}
		})));
	}

}
