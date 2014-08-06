package org.psjava.ds.numbersystrem;

import org.psjava.util.AssertStatus;

public class InfinitableNumber<T> {

	public static <T> InfinitableNumber<T> getFiniteInstance(T value) {
		return new InfinitableNumber<T>(value);
	}

	public static <T> InfinitableNumber<T> getInfinity() {
		return new InfinitableNumber<T>(null);
	}

	private final T valueOrNull; // null means infinity

	private InfinitableNumber(T valueOrNull) {
		this.valueOrNull = valueOrNull;
	}

	public boolean isInfinity() {
		return valueOrNull == null;
	}

	public T getValue() {
		AssertStatus.assertTrue(valueOrNull != null);
		return valueOrNull;
	}

}
