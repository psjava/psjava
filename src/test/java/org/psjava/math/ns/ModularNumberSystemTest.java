package org.psjava.math.ns;

import org.junit.Assert;
import org.junit.Test;


public class ModularNumberSystemTest {
	
	@Test
	public void testAdd() {
		ModularNumberSystem<Int32> ns = create();
		Assert.assertEquals(4, ns.add(Int32.valueOf(9), Int32.valueOf(5)).v);		
		Assert.assertEquals(6, ns.add(Int32.valueOf(-9), Int32.valueOf(-5)).v);		
	}

	@Test
	public void testMultiply() {
		ModularNumberSystem<Int32> ns = create();
		Assert.assertEquals(4, ns.multiply(Int32.valueOf(-9), Int32.valueOf(4)).v);		
	}
	
	private static ModularNumberSystem<Int32> create() {
		return new ModularNumberSystem<Int32>(new Int32System(), Int32.valueOf(10));
	}

}
