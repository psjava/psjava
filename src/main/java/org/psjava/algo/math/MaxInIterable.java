package org.psjava.algo.math;

import java.util.Comparator;

import org.psjava.util.AssertStatus;

public class MaxInIterable {

	public static <T> T max(Iterable<T> iterable, Comparator<T> comp) {
		T max = null;
		for (T a : iterable)
			if (max == null || comp.compare(max, a) < 0)
				max = a;
		AssertStatus.assertTrue(max != null, "Empty Iterable");
		return max;
	}

}
