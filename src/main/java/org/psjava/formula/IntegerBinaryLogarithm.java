package org.psjava.formula;

import org.psjava.util.AssertStatus;

public class IntegerBinaryLogarithm {

	public static int calc(int v) {
		AssertStatus.assertTrue(v >= 1);
		return 31 - Integer.numberOfLeadingZeros(v);
	}

	private IntegerBinaryLogarithm() {
	}
}
