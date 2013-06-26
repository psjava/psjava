package org.psjava.math;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.math.ns.Int32;
import org.psjava.math.ns.Int32NumberSystem;


public class ModuloTest {

	@Test
	public void test() {
		Int32NumberSystem ns = new Int32NumberSystem();
		Assert.assertEquals(1, Modulo.calc(ns, Int32.valueOf(10), Int32.valueOf(3)).v);
		Assert.assertEquals(2, Modulo.calc(ns, Int32.valueOf(-10), Int32.valueOf(3)).v);
	}
}
