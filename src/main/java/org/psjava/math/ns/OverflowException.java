package org.psjava.math.ns;

public class OverflowException {

	public static ArithmeticException create() {
		return new ArithmeticException("Overflow");
	}

}
