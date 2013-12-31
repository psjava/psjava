package org.psjava.ds.map;

import org.junit.Assert;
import org.junit.Test;

public class MapEntryEqualityTesterTest {

	@Test
	public void testNullValue() {
		Assert.assertTrue(MapEntryEqualityTester.are(create(1, null), create(1, null)));
		Assert.assertFalse(MapEntryEqualityTester.are(create(1, null), create(1, 2)));
		Assert.assertFalse(MapEntryEqualityTester.are(create(1, 2), create(1, null)));
	}

	private static MapEntry<Integer, Integer> create(final Integer k, final Integer v) {
		return new MapEntry<Integer, Integer>() {
			@Override
			public Integer getKey() {
				return k;
			}

			@Override
			public Integer getValue() {
				return v;
			}
		};
	}
}
