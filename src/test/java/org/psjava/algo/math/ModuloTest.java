package org.psjava.algo.math;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.math.Modulo;
import org.psjava.ds.numbersystrem.Int32;
import org.psjava.ds.numbersystrem.Int32NumberSystem;


public class ModuloTest {

	@Test
	public void test() {
		Int32NumberSystem ns = new Int32NumberSystem();
		Assert.assertEquals(1, Modulo.calc(ns, Int32.valueOf(10), Int32.valueOf(3)).v);
		Assert.assertEquals(2, Modulo.calc(ns, Int32.valueOf(-10), Int32.valueOf(3)).v);
	}
}
