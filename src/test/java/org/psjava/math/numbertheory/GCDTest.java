package org.psjava.math.numbertheory;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.math.ns.Int32;
import org.psjava.math.ns.Int32NumberSystem;

public class GCDTest {

	private static final Int32NumberSystem NS = new Int32NumberSystem();

	@Test
	public void test1() {
		Assert.assertEquals(8, GCD.gcd(NS, toValue(24), toValue(16)).v);
	}

	@Test
	public void test2() {
		Assert.assertEquals(1, GCD.gcd(NS, toValue(1), toValue(123812733)).v);
	}

	@Test
	public void test3() {
		Assert.assertEquals(1, GCD.gcd(NS, toValue(113213123), toValue(1)).v);
	}

	private Int32 toValue(int v) {
		return Int32.valueOf(v);
	}

}
