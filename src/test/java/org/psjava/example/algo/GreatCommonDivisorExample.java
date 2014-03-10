package org.psjava.example.algo;

import java.math.BigInteger;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.math.numbertheory.GCD;
import org.psjava.ds.numbersystrem.BigIntegerNumberSystem;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.ds.numbersystrem.LongNumberSystem;

/**
 * @implementation {@link GCD}
 */
public class GreatCommonDivisorExample {

	@Test
	public void example() {
		// Usage is very simple. Remember that you can use various systems.

		int gcd1 = GCD.gcd(IntegerNumberSystem.getInstance(), 25, 10);
		long gcd2 = GCD.gcd(LongNumberSystem.getInstance(), 25L, 10L);
		BigInteger gcd3 = GCD.gcd(BigIntegerNumberSystem.getInstance(), BigInteger.valueOf(25), BigInteger.valueOf(10));

		Assert.assertEquals(5, gcd1);
		Assert.assertEquals(5L, gcd2);
		Assert.assertEquals(BigInteger.valueOf(5), gcd3);
	}

}
