package org.psjava.util;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.Collection;
import org.psjava.ds.array.ArrayFromValues;
import org.psjava.util.MergedCollection;


public class MergedCollectionTest {
	@Test
	public void test() {
		Collection<Integer> c1 = ArrayFromValues.create(1, 2);
		Collection<Integer> c2 = ArrayFromValues.create(3, 4);
		@SuppressWarnings("unchecked")
		Collection<Integer> merged = MergedCollection.wrap(ArrayFromValues.create(c1, c2));
		Assert.assertEquals(4, merged.size());
		Assert.assertFalse(merged.isEmpty());
		Assert.assertEquals("(1,2,3,4)", merged.toString());
	}
}
