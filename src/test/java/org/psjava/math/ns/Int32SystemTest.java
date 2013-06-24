package org.psjava.math.ns;

import org.junit.Assert;
import org.junit.Test;


public class Int32SystemTest {

	IntegerDivisableNumberSystem<Int32> ns = new Int32System();

	@Test (expected=ArithmeticException.class)
	public void testAddOverflow() {
		ns.add(Int32.valueOf(2000000000), Int32.valueOf(1000000000));
	}
	
	@Test (expected=ArithmeticException.class)
	public void testSubtractOverflow() {
		ns.subtract(Int32.valueOf(-1000000000), Int32.valueOf(+2000000000));
	}
	
	@Test (expected=ArithmeticException.class)
	public void testSubtractOverflow2() {
		ns.subtract(Int32.valueOf(Integer.MIN_VALUE), ns.getOne());
	}
	
	@Test (expected=ArithmeticException.class)
	public void testMultiplyOverflow() {
		ns.multiply(Int32.valueOf(1000000), Int32.valueOf(2000000));
	}
	
	@Test
	public void testIntegerRemainder() {
		Assert.assertEquals(-1,  ns.integerRemainder(Int32.valueOf(-10), Int32.valueOf(3)).v);
	}

	@Test
	public void testValueOf() throws Exception {
		Assert.assertEquals(1, Int32.valueOf(1).v);
		Assert.assertEquals(Integer.MAX_VALUE, Int32.valueOf(Integer.MAX_VALUE).v);
	}
	
}
