package org.psjava.util;

import static org.junit.Assert.*;
import static org.psjava.TestUtil.toArrayList;
import org.junit.Test;
import org.psjava.TestUtil;
import org.psjava.util.DataFilter;
import org.psjava.util.FilteredIterator;

public class FilteredIteratorTest {

	@Test
	public void testCreate() {
		assertEquals(toArrayList(2, 4), TestUtil.toArrayListFromIterator(FilteredIterator.create(toArrayList(1, 2, 3, 4, 5).iterator(), new DataFilter<Integer>() {
			@Override
			public boolean isAccepted(Integer v) {
				return v % 2 == 0;
			}
		})));
	}

}
