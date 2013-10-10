package org.psjava.ds.numbersystrem;


import org.junit.Assert;
import org.junit.Test;
import org.psjava.util.FactoryByInt;

public class CacheByIntegerRangeTest {

	@Test
	public void testGet() throws Exception {
		CacheByIntegerRange<Object> cache = new CacheByIntegerRange<Object>(-10,+10, new FactoryByInt<Object>() {
			@Override
			public Object create(int value) {
				return new Object();
			}			
		});
		Assert.assertEquals(20, cache.cache.length);
		Assert.assertTrue(cache.cache[0] == cache.get(-10));
		Assert.assertTrue(cache.cache[19] == cache.get(9));
	}

}
