package org.psjava.math;

import java.util.Comparator;

public class MaxInIterable {

	public static <T> T max(Iterable<T> iterable, Comparator<T> comp) {
		T max = null;
		for(T a : iterable) 
			if(max == null || comp.compare(max, a) < 0)
				max = a;
		if(max == null)
			throw new IllegalArgumentException("Empty Iterable");			
		return max;
	}

}
