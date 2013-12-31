package org.psjava.ds.map;

import org.junit.Assert;
import org.junit.Test;

public class MapEntryHashTest {

	@Test
	public void test() {
		int r = MapEntryHash.hash(new MapEntry<Integer, Integer>() {
			@Override
			public Integer getKey() {
				return 1;
			}

			@Override
			public Integer getValue() {
				return null;
			}
		});
		Assert.assertEquals(1, r);
	}
}
