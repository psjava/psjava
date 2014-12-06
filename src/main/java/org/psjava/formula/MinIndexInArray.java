package org.psjava.formula;

import org.psjava.ds.array.Array;
import org.psjava.util.ReversedComparator;

import java.util.Comparator;

public class MinIndexInArray {
	public static <T> int get(Array<T> c, Comparator<T> comp) {
		return MaxIndexInArray.get(c, ReversedComparator.wrap(comp));
	}
}
