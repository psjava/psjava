package org.psjava.algo.sequence.rmq;

import java.util.Comparator;

import org.psjava.ds.array.Array;

public class RMQUtil {

	static <T> int selectSmallestIndex(final Array<T> a, int i1, int i2, final Comparator<T> comp) {
		if (comp.compare(a.get(i1), a.get(i2)) < 0)
			return i1;
		else
			return i2;
	}

}
