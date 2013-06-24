package org.psjava.javautil;

public class FromTo {

	public static Iterable<Integer> get(int begin, int end) {
		return IntSequenceIterable.create(begin, 1, end-begin);
	}

}
